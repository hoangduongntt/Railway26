package com.fsoft.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "Employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="employeeId",  nullable = false, unique = true)
    private int id;

    @Column(name ="account", length = 50, nullable = false,unique = true)
    private String account;

    @Column(name ="department", length = 10, nullable = false,unique = false)
    private String department;

    @Column(name ="employeeAddress", length = 50, nullable = false,unique = false)
    private String employeeAddress;


    @Column(name ="employeeBirthday", nullable = false,unique = false)
    @Temporal(TemporalType.DATE)
    private Date employeeBirthday;

    @Column(name ="employeeEmail", length = 50, nullable = false,unique = true)
    private String employeeEmail;


    @Column(name ="employeeName", length = 50, nullable = false,unique = false)
    private String employeeName;

    @Column(name ="employeePhone", length = 10, nullable = false,unique = true)
    private String employeePhone;

    @Column(name ="passWord", length = 20, nullable = false,unique = false)
    private String passWord;

    @Column(name ="sex", length = 1, nullable = false,unique = false)
    private String sex;

    public Employee(String account, String department, String employeeAddress, Date employeeBirthday, String employeeEmail, String employeeName, String employeePhone, String passWord, String sex) {
        this.account = account;
        this.department = department;
        this.employeeAddress = employeeAddress;
        this.employeeBirthday = employeeBirthday;
        this.employeeEmail = employeeEmail;
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
        this.passWord = passWord;
        this.sex = sex;
    }

    public Employee() {

    }
}
