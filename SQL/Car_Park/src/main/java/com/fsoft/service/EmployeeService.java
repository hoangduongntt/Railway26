package com.fsoft.service;

import com.fsoft.dto.EmployeeDTO;
import com.fsoft.entity.Employee;
import com.fsoft.form.EmployeeFilter;
import com.fsoft.repository.EmployeeRepository;
import com.fsoft.specification.EmployeeSpecification;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ModelMapper modelMapper;

    public Page<EmployeeDTO> getAllEmployee(Pageable pageable, String search, EmployeeFilter employeeFilter){

        Specification<Employee> where = EmployeeSpecification.buidWhere(search, employeeFilter );
        Page<Employee> employeePage = employeeRepository.findAll(where, pageable);
        List<EmployeeDTO> dtos = modelMapper.map(employeePage.getContent(), new TypeToken<List<EmployeeDTO>>(){}.getType());
        Page<EmployeeDTO>  employeeDTOPages = new PageImpl<>(dtos, pageable, employeePage.getTotalElements());
        return  employeeDTOPages;
    }

    public EmployeeDTO addEmployee(Employee employee){
        EmployeeDTO dto = modelMapper.map(employeeRepository.save(employee), EmployeeDTO.class);
        return dto;
    }

    public void updateEmployee(Employee employee, int id){
            Optional<Employee> employeeUpdate = Optional.of(employeeRepository.findById(id).map(emp -> {
                emp.setAccount(employee.getAccount());
                emp.setEmployeeEmail(employee.getEmployeeEmail());
                emp.setEmployeeAddress(employee.getEmployeeAddress());
                emp.setEmployeeName(employee.getEmployeeName());
                emp.setEmployeePhone(employee.getEmployeePhone());
                emp.setEmployeeBirthday(employee.getEmployeeBirthday());
                emp.setDepartment(employee.getDepartment());
                emp.setPassWord(employee.getPassWord());
                emp.setSex(employee.getSex());
                employeeRepository.save(emp);
                return emp;
            }).orElseGet(() -> {
                employeeRepository.save(employee);
                return employee;
            }));
            }

    public boolean deleteEmployeeById(int id){
        boolean isEmployeeExist = employeeRepository.existsById(id);
        if(isEmployeeExist){
            employeeRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
