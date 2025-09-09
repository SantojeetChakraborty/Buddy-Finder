package com.bikeridersupport.buddyfinder.controller;

import com.bikeridersupport.buddyfinder.model.AppUser;
import com.bikeridersupport.buddyfinder.model.dto.UserRequest;
import com.bikeridersupport.buddyfinder.model.dto.UserResponse;
import com.bikeridersupport.buddyfinder.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class AppUserController {

    private final UserServiceImpl appUserService;

    @PostMapping()
    public ResponseEntity<String> createUser(@RequestBody @Valid UserRequest userRequest){
        appUserService.saveUser(userRequest);
        return new ResponseEntity<>("User created Successfully",HttpStatus.CREATED);
    }

    @GetMapping()
    @PreAuthorize("hasRole('APP_USER')")
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return new ResponseEntity<>(appUserService.getAllAppUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable @Valid String id){
        return new ResponseEntity<>(appUserService.getUserById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUserById(@RequestBody UserRequest userRequest,
                                                 @PathVariable @Valid String id){
        appUserService.updateUser(userRequest,id);
        return new ResponseEntity<>("User updated successfully",HttpStatus.OK);
    }

    @GetMapping("/profile")
    @PreAuthorize("hasRole('APP_USER')")
    public ResponseEntity<AppUser> getProfile(@AuthenticationPrincipal AppUser currentUser) {
        return ResponseEntity.ok(currentUser);
    }
}
