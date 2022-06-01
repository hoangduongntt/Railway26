package com.fsoft.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TripDTO {
    private int id;
    private String destination;
    private Date departureTime;
    private String driver;
    private String carType;
    private int bookedTicketNumber;
}
