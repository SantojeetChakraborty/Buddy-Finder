package com.bikeridersupport.buddyfinder.model.dto;

import lombok.Data;

@Data
public class RatingResponse {
    private double averageRating;
    private int totalRatings;
}
