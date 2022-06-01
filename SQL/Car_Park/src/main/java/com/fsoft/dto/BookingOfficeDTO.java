package com.fsoft.dto;

import com.fsoft.entity.Trip;
import lombok.Data;

import java.util.Date;

@Data
public class BookingOfficeDTO {
    private int id;
    private String officeName;
    private String tripDestination;
}
