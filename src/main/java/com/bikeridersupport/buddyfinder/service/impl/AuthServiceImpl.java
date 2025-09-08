package com.bikeridersupport.buddyfinder.service.impl;

import com.bikeridersupport.buddyfinder.model.AppUser;
import com.bikeridersupport.buddyfinder.model.BaseUser;
import com.bikeridersupport.buddyfinder.model.BuddyStatus;
import com.bikeridersupport.buddyfinder.model.BuddyUser;
import com.bikeridersupport.buddyfinder.model.dto.AuthRequest;
import com.bikeridersupport.buddyfinder.model.dto.AuthResponse;
import com.bikeridersupport.buddyfinder.model.dto.RegisterRequest;
import com.bikeridersupport.buddyfinder.repository.BuddyRepository;
import com.bikeridersupport.buddyfinder.repository.UserRepository;
import com.bikeridersupport.buddyfinder.security.CustomUserDetailsService;
import com.bikeridersupport.buddyfinder.security.JwtUtil;
import com.bikeridersupport.buddyfinder.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository appUserRepository;
    private final BuddyRepository buddyUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        BaseUser user = (BaseUser) userDetails;

        return buildAuthResponse(user, token, "Authentication successful");
    }

    public AuthResponse registerAppUser(RegisterRequest request) {
        validateUserUniqueness(request);

        AppUser appUser = new AppUser();
        appUser.setUsername(request.getUsername());
        appUser.setEmail(request.getEmail());
        appUser.setPassword(passwordEncoder.encode(request.getPassword()));
        appUser.setWalletBalance(0.0);

        appUser = appUserRepository.save(appUser);
        String token = jwtUtil.generateToken(appUser);

        return buildAuthResponse(appUser, token, "App user registered successfully");
    }

    /**
     * Register a Buddy User
     */
    public AuthResponse registerBuddy(RegisterRequest request) {
        validateUserUniqueness(request);

        BuddyUser buddyUser = new BuddyUser();
        buddyUser.setUsername(request.getUsername());
        buddyUser.setEmail(request.getEmail());
        buddyUser.setPassword(passwordEncoder.encode(request.getPassword()));
        buddyUser.setWalletBalance(0.0);
        buddyUser.setCurrentStatus(BuddyStatus.CLOSED);

        buddyUser = buddyUserRepository.save(buddyUser);
        String token = jwtUtil.generateToken(buddyUser);

        return buildAuthResponse(buddyUser, token, "Buddy user registered successfully");
    }

    public AuthResponse refreshToken(String bearerToken) {
        String token = bearerToken.substring(7);
        String username = jwtUtil.extractUsername(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if (!jwtUtil.validateToken(token, userDetails)) {
            throw new RuntimeException("Invalid token");
        }

        String newToken = jwtUtil.generateToken(userDetails);
        BaseUser user = (BaseUser) userDetails;
        return buildAuthResponse(user, newToken, "Token refreshed successfully");
    }

    private void validateUserUniqueness(RegisterRequest request) {
        boolean usernameExists = appUserRepository.findByUsername(request.getUsername()) != null
                || buddyUserRepository.findByUsername(request.getUsername()) != null;
        if (usernameExists) {
            throw new RuntimeException("Username already exists");
        }

        boolean emailExists = appUserRepository.findByEmail(request.getEmail()) != null
                || buddyUserRepository.findByEmail(request.getEmail()) != null;
        if (emailExists) {
            throw new RuntimeException("Email already exists");
        }
    }


    private AuthResponse buildAuthResponse(BaseUser user, String token, String message) {
        return AuthResponse.builder()
                .token(token)
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .message(message)
                .build();
    }
}
