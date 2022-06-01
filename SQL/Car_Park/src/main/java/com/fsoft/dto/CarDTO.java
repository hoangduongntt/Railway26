package com.fsoft.dto;

import com.fsoft.entity.Parkinglot;
import lombok.Data;

@Data
public class CarDTO {
    private String licensePlate;
    private String carType;
    private String carColor;
    private String company;
    private String parkinglotParkName;
}
