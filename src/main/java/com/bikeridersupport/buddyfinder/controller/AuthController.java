package com.bikeridersupport.buddyfinder.controller;

import com.bikeridersupport.buddyfinder.model.dto.AuthRequest;
import com.bikeridersupport.buddyfinder.model.dto.AuthResponse;
import com.bikeridersupport.buddyfinder.model.dto.RegisterRequest;
import com.bikeridersupport.buddyfinder.service.impl.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthServiceImpl authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping("/register/app-user")
    public ResponseEntity<AuthResponse> registerAppUser(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.registerAppUser(request));
    }

    @PostMapping("/register/buddy")
    public ResponseEntity<AuthResponse> registerBuddy(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.registerBuddy(request));
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refresh(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(authService.refreshToken(token));
    }

}
