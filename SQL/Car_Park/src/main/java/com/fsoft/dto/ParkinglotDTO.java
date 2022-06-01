package com.fsoft.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ParkinglotDTO {
    private int id;
    private String parkName;
    private String parkPlace;
    private  int parkArea;
    private int parkPrice;
    private String parkStatus;
}
