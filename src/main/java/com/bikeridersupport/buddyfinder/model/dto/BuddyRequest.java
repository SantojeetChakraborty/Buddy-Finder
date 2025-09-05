package com.bikeridersupport.buddyfinder.model.dto;

import com.bikeridersupport.buddyfinder.model.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BuddyRequest {
    @NotBlank(message = "Username cannot be blank")
    private String username;
    @Email(message = "Enter a valid Email")
    @NotBlank(message = "Email cannot be blank")
    private String email;
    @NotBlank(message = "Password cannot be blank")
    private String password;
    private Address address;
}
