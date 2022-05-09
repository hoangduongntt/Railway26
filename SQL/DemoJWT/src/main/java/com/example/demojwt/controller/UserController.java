package com.example.demojwt.controller;

import com.example.demojwt.service.JwtUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    JwtUserDetailService jwtUserDetailService;

    @RequestMapping(value = "/hello" )
    public String firstPage() {
        return "Hello World";
    }


}
