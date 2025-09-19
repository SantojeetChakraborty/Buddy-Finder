package com.bikeridersupport.buddyfinder.model.dto;

import com.bikeridersupport.buddyfinder.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String token;
    private String username;
    private String email;
    private String password;
    private Address shopAddress;
}
