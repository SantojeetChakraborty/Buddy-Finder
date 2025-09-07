package com.bikeridersupport.buddyfinder.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public abstract class BaseUser {
    @Id
    private ObjectId id;
    private String username;
    private String email;
    private String password;
    double walletBalance;
    Rating rating;
}
