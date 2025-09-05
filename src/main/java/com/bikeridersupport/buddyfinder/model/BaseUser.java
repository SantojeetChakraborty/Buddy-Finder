package com.bikeridersupport.buddyfinder.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "users")
public class BaseUser {
    @Id
    private String id;

    private String username;
    private String email;
    private String password;
    private Address address;

    @Field("role")
    private Role role;
    @Field("app_user_membership_status")
    private UserMembership userMembership;
    @Field("buddy_status")
    private BuddyStatus buddyStatus;

    private List<Booking> bookingHistory = new ArrayList<>();
    private List<Vehicle> myVehicles = new ArrayList<>();
    private Rating myRating;

}
