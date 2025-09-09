package com.bikeridersupport.buddyfinder.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "app_users")
public class AppUser extends BaseUser{

    Address currentLocation;
    Booking currentBooking;
    List<Address> locations;
    List<Booking> bookingHistory;
    Vehicle currentVehicle;
    List<Vehicle> myVehicles;
    Role role;

    @Override
    public Role getRole() {
        return Role.APP_USER;
    }
}
