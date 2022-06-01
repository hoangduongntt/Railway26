package com.fsoft.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Car")
public class Car {
    @Id
    @Column(name ="licensePlate", length = 50, nullable = false, unique = true)
    private String licensePlate;

    @Column(name ="carColor",length = 11, nullable = false,unique = false)
    private String carColor;

    @Column(name ="carType", length = 50, nullable = false,unique = false)
    private String carType;

    @Column(name ="company", length = 50,nullable = false,unique = false)
    private String company;

    @OneToMany(mappedBy = "car",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Ticket> ticketList;

    @ManyToOne
    @JoinColumn(name = "parkId")
    private Parkinglot parkinglot;
    public Car(String licensePlate, String carColor, String carType, String company) {
        this.licensePlate = licensePlate;
        this.carColor = carColor;
        this.carType = carType;
        this.company = company;


    }

    public Car(String licensePlate, String carColor, String carType, String company, Set<Ticket> ticketList, Parkinglot parkinglot) {
        this.licensePlate = licensePlate;
        this.carColor = carColor;
        this.carType = carType;
        this.company = company;
        this.ticketList = ticketList;
        this.parkinglot = parkinglot;
    }

    public Car() {
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Set<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(Set<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public Parkinglot getParkinglot() {
        return parkinglot;
    }

    public void setParkinglot(Parkinglot parkinglot) {
        this.parkinglot = parkinglot;
    }


}
