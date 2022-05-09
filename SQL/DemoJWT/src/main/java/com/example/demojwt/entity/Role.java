package com.example.demojwt.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Role")

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String role  ;

    @ManyToMany(mappedBy = "roles", fetch =  FetchType.EAGER)
    private Set<User> users = Set.of() ;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }


}
