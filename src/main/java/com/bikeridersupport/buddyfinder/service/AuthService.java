package com.bikeridersupport.buddyfinder.service;

import com.bikeridersupport.buddyfinder.model.dto.AuthRequest;
import com.bikeridersupport.buddyfinder.model.dto.AuthResponse;
import com.bikeridersupport.buddyfinder.model.dto.RegisterRequest;
import org.springframework.security.core.Authentication;

public interface AuthService {
     AuthResponse authenticate(AuthRequest request);
     AuthResponse registerAppUser(RegisterRequest registerRequest);
    AuthResponse registerBuddy(RegisterRequest registerRequest);
    AuthResponse refreshToken(String bearerToken);
}
