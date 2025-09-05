package com.bikeridersupport.buddyfinder.model.dto;

import com.bikeridersupport.buddyfinder.model.BuddyStatus;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BuddyResponse {
    private double walletBalance = 0.0;
    private List<BookingResponse> bookingHistory = new ArrayList<>();
    private RatingResponse myRating;
    private BuddyStatus buddyStatus;
}
