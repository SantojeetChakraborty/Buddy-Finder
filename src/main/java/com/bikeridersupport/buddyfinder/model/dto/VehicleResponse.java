package com.bikeridersupport.buddyfinder.model.dto;

import lombok.Data;

@Data
public class VehicleResponse {
    private String id;
    private String vehicleType;
    private String registrationNumber;
}
