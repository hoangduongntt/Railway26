package com.fsoft.repository;

import com.fsoft.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> , JpaSpecificationExecutor<Employee> {
    @Query("SELECT e FROM Employee e WHERE CONCAT(e.id, e.employeeName, e.employeeBirthday,e.employeeAddress,e.employeePhone,e.department)  LIKE %?1%")
    public List<Employee> search (String keyword);

}
