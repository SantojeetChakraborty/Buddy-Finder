package com.bikeridersupport.buddyfinder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Booking {

    private String id;
    private String date;
    private String location;
    private String status;
}
