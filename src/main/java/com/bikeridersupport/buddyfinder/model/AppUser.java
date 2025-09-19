package com.bikeridersupport.buddyfinder.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "app_users")
public class AppUser extends BaseUser{

    Address currentLocation = new Address();
    Booking currentBooking = new Booking();
    List<Address> locations = new ArrayList<>();
    List<Booking> bookingHistory = new ArrayList<>();
    Vehicle currentVehicle = new Vehicle();
    List<Vehicle> myVehicles = new ArrayList<>();
    Role role;

    @Override
    public Role getRole() {
        return Role.APP_USER;
    }
}
