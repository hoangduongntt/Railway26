package com.example.demojwt.config;

import com.example.demojwt.entity.Role;
import com.example.demojwt.entity.User;
import com.example.demojwt.repository.RoleRepository;
import com.example.demojwt.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ConfigData {
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, RoleRepository roleRepository){

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Role role1 = new Role("ROLE_USER");
                Role role2 = new Role("ROLE_ADMIN");
                Role role3 = new Role("ROLE_MANAGER");
                role1 = roleRepository.save(role1);
                role2 = roleRepository.save(role2);
                role3 = roleRepository.save(role3);


                User user1 = new User("hoangduong", "$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi",25, "Ha Noi");
                Set<Role> roles1 = new HashSet<Role>();
                roles1.add(role1);
                user1.setRoles(roles1);
                User user2 = new User("hoangduong1", "$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi",24,"Thanh Hoa");
                Set<Role> roles2 = new HashSet<>();
                roles2.add(role2);
                user2.setRoles(roles2);
                User user3 = new User("hoangduong2", "$2a$10$g8mHxLVta0lK7KBa52CP1ehCtDYMM9E8QIzrt0utSlu2egvEtIFR6",25,"Ha Noi");
                Set<Role> roles3 = new HashSet<Role>();
                roles3.add(role3);
                user3.setRoles(roles3);
                userRepository.save(user1);
                userRepository.save(user2);
                userRepository.save(user3);

            }
        };
    }
}
