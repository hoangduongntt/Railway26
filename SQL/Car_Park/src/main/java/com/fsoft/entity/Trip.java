package com.fsoft.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trip")

public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="tripId",  nullable = false, unique = true)
    private int id;

    @Column(name ="bookedTicketNumber",length = 11, nullable = false,unique = false)
    private int bookedTicketNumber;

    @Column(name ="carType", length = 11, nullable = false,unique = false)
    private String carType;

    @Column(name ="departureDate", nullable = false,unique = false)
    @Temporal(TemporalType.DATE)
    private Date departureDate;

    @Column(name ="departureTime", nullable = false,unique = false)
    @Temporal(TemporalType.TIME)
    private Date departureTime;

    @Column(name ="destination", length = 50, nullable = false,unique = false)
    private String destination;

    @Column(name ="driver", length = 11, nullable = false,unique = false)
    private String driver;

    @Column(name ="maximumOnlineTicketNumber", length = 11, nullable = false,unique = false)
    private int maximumOnlineTicketNumber;

    @OneToMany(mappedBy = "trip", fetch =  FetchType.LAZY, cascade =  CascadeType.ALL)
    private Set<Ticket> ticketList;


    @OneToMany(mappedBy = "trip", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<BookingOffice> bookingOffices;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookedTicketNumber() {
        return bookedTicketNumber;
    }

    public void setBookedTicketNumber(int bookedTicketNumber) {
        this.bookedTicketNumber = bookedTicketNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getMaximumOnlineTicketNumber() {
        return maximumOnlineTicketNumber;
    }

    public void setMaximumOnlineTicketNumber(int maximumOnlineTicketNumber) {
        this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
    }

    public Set<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(Set<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public Set<BookingOffice> getBookingOffices() {
        return bookingOffices;
    }

    public void setBookingOffices(Set<BookingOffice> bookingOffices) {
        this.bookingOffices = bookingOffices;
    }

    public Trip(int bookedTicketNumber, String carType, Date departureDate, Date departureTime, String destination, String driver, int maximumOnlineTicketNumber) {
        this.bookedTicketNumber = bookedTicketNumber;
        this.carType = carType;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.destination = destination;
        this.driver = driver;
        this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
        this.ticketList = new HashSet<>();
        this.bookingOffices = new HashSet<>();
    }

    public Trip() {
    }

}
