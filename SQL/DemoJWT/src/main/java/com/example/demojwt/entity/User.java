package com.example.demojwt.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "User")


public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = false)
    private String userName;
    private String passWord;
    private int age;
    private String address;

    @ManyToMany(fetch =  FetchType.EAGER)
    @JoinTable(name = "User_Role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = Set.of() ;

    public User() {
    }

    public User(String userName, String passWord, int age, String address) {
        this.userName = userName;
        this.passWord = passWord;
        this.age = age;
        this.address = address;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


}
