package com.fsoft.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name = "Ticket")
@Data //
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ticketId",  nullable = false, unique = true)
    private int id;

    @Column(name ="bookingTime", nullable = false,unique = false)
    @Temporal(TemporalType.TIME)
    private Date bookingTime;

    @Column(name ="customerName", length = 11, nullable = false,unique = false)
    private String customerName;

    @ManyToOne
    @JoinColumn(name = "tripId")
    private Trip trip;

    @ManyToOne
    @JoinColumn(name = "licensePlate")
    private Car car;


    public Ticket(Date bookingTime, String customerName, Trip trip, Car car) {
        this.bookingTime = bookingTime;
        this.customerName = customerName;
        this.trip = trip;
        this.car = car;
    }

    public Ticket() {
    }

    // ??? set car ??



}
