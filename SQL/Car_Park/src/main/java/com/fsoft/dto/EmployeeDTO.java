package com.fsoft.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDTO {
    private int id;
    private String employeeName;
    private Date employeeBirthday;
    private String employeeAddress;
    private String employeePhone;
    private String department;
}
