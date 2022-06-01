package com.fsoft.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TicketDTO {
    private int id;
    private String tripDestination;
    private String carLicensePlate;
    private String customerName;
    private Date bookingTime;
}
