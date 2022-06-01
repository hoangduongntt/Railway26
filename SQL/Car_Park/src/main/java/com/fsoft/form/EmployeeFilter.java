package com.fsoft.form;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class EmployeeFilter {
    private Integer minId;
    private Integer maxId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date minBirthDay;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxBirthDay;
}
