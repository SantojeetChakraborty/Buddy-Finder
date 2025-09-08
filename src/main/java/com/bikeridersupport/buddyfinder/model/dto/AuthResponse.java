package com.bikeridersupport.buddyfinder.model.dto;

import com.bikeridersupport.buddyfinder.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {
    private String token;
    private String username;
    private String email;
    private Role role;
    private String message;
}
