package com.example.demojwt.ultil;

import com.example.demojwt.entity.User;
import com.example.demojwt.model.UserDTO;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
@Component
public class Converter {
    public UserDTO getAllUser(User user){
        UserDTO dto = new UserDTO();
        dto.setUserName(user.getUserName());
        dto.setPassWord(user.getPassWord());
        dto.setAddress(user.getAddress());
        dto.setAge(user.getAge());
        dto.setRoles(user.getRoles().stream().map(role -> role.getRole()).collect(Collectors.toSet()));
        return dto;
    }
}
