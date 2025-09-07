package com.bikeridersupport.buddyfinder.service;

import com.bikeridersupport.buddyfinder.model.dto.UserRequest;
import com.bikeridersupport.buddyfinder.model.dto.UserResponse;

import java.util.List;

public interface UserService {
    void saveUser(UserRequest user);
    List<UserResponse> getAllAppUsers();
    UserResponse getUserById(String id);
    void updateUser(UserRequest userRequest,String id);
}
