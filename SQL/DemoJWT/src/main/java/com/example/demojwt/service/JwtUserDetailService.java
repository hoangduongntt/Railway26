package com.example.demojwt.service;

import com.example.demojwt.entity.Role;
import com.example.demojwt.entity.User;
import com.example.demojwt.model.UserDTO;
import com.example.demojwt.repository.RoleRepository;
import com.example.demojwt.repository.UserRepository;
import com.example.demojwt.ultil.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JwtUserDetailService implements UserDetailsService {
    @Autowired
    Converter converter;
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UserDTO> getAllUser() {
        return userRepository.findAll().stream().map(user -> converter.getAllUser(user)).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         Check user exists by username
        User user = userRepository.findByUserName(username);
        if (user==null){
            throw new UsernameNotFoundException(username);
        }
        Set<Role> roles = user.getRoles();
        Set<GrantedAuthority> c_auth = new HashSet<>();
        for(Role r: roles){
            c_auth.add(new SimpleGrantedAuthority(r.getRole()));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassWord(),
                c_auth
        );

    }
    public User addUser(User user){
            User newUser = new User();
            newUser.setUserName(user.getUserName());
            newUser.setPassWord(passwordEncoder.encode(user.getPassWord()));
            newUser.setAddress(user.getAddress());
            newUser.setAge(user.getAge());
            Set<Role> inputRoles = user.getRoles();
            Set<Role> roles = new HashSet<>();
            if (inputRoles==null){
                Role useRole = roleRepository.findByRole("ROLE_USER");
                if(useRole!=null) {
                    roles.add(useRole);
                }else {
                    throw new RuntimeException("Error : Role is not found");
                }
            }else {
                for (Role role:inputRoles) {
                    roles.add(role);
                }
                        }
            newUser.setRoles(roles);
            userRepository.save(newUser);
            return newUser;
    }
}

