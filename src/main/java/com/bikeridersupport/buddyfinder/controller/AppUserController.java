package com.bikeridersupport.buddyfinder.controller;

import com.bikeridersupport.buddyfinder.model.User;
import com.bikeridersupport.buddyfinder.model.dto.UserRequest;
import com.bikeridersupport.buddyfinder.model.dto.UserResponse;
import com.bikeridersupport.buddyfinder.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return new ResponseEntity<>(appUserService.getAllAppUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable @Valid String id){
        return new ResponseEntity<>(appUserService.getUserById(id), HttpStatus.OK);
    }
}
