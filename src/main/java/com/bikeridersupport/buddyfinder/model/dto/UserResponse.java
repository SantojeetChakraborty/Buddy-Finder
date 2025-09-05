package com.bikeridersupport.buddyfinder.model.dto;

import com.bikeridersupport.buddyfinder.model.UserMembership;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserResponse {

    private double walletBalance = 0.0;
    private List<BookingResponse> bookingHistory = new ArrayList<>();
    private List<VehicleResponse> myVehicles = new ArrayList<>();
    private RatingResponse myRating;
    private UserMembership membershipStatus = UserMembership.NORMAL;
}
