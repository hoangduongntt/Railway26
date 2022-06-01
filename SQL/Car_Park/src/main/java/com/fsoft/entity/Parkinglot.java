package com.fsoft.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "parkinglot")
@Data

public class Parkinglot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="parkId", nullable = false, unique = true)
    private int id;

    @Column(name ="parkArea",length = 20, nullable = false,unique = true)
    private  int parkArea;

    @Column(name ="parkName", length = 50, nullable = false,unique = true)
    private String parkName;

    @Column(name ="parkPlace", length = 11, nullable = false,unique = true)
    private String parkPlace;

    @Column(name ="parkPrice", length = 20,nullable = false,unique = false)
    private int parkPrice;

    @Column(name ="parkStatus", length = 50, nullable = false,unique = false)
    private String parkStatus;

    @OneToMany(mappedBy ="parkinglot", fetch =  FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Car> carList;

    public Parkinglot(int parkArea, String parkName, String parkPlace, int parkPrice, String parkStatus) {
        this.parkArea = parkArea;
        this.parkName = parkName;
        this.parkPlace = parkPlace;
        this.parkPrice = parkPrice;
        this.parkStatus = parkStatus;
    }

    public Parkinglot() {
    }
}
