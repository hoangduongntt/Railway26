package com.fsoft.controller;

import com.fsoft.config.ResponseObject;
import com.fsoft.dto.EmployeeDTO;
import com.fsoft.entity.Employee;
import com.fsoft.form.EmployeeFilter;
import com.fsoft.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("")
    public Page<EmployeeDTO> getAllEmployee(Pageable pageable, @RequestParam(value = "search", required = false) String search, EmployeeFilter employeeFilter){
        return employeeService.getAllEmployee(pageable, search, employeeFilter);

    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> addEmployee(@RequestBody  Employee employee){
        employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert Success"  )
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updateEmployee(@RequestBody  Employee employee, @PathVariable int id){
        employeeService.updateEmployee(employee,id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Update Success !")
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> deleteById(@PathVariable int id){
       boolean flag = employeeService.deleteEmployeeById(id);
        if (flag){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete Scucess !"));
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject  ("fail", "Find not id, please check again !"));
        }
    }
}
