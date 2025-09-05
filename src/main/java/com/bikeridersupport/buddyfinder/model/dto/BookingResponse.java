package com.bikeridersupport.buddyfinder.model.dto;

import lombok.Data;

@Data
public class BookingResponse {
    private String id;
    private String date;
    private double price;
    private String status;
}
