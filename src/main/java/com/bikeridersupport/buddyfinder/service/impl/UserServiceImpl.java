package com.bikeridersupport.buddyfinder.service.impl;


import com.bikeridersupport.buddyfinder.model.AppUser;
import com.bikeridersupport.buddyfinder.model.Role;
import com.bikeridersupport.buddyfinder.model.dto.UserRequest;
import com.bikeridersupport.buddyfinder.model.dto.UserResponse;
import com.bikeridersupport.buddyfinder.repository.UserRepository;
import com.bikeridersupport.buddyfinder.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository appUserRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Override
    public void saveUser(UserRequest userRequest) {
        AppUser user = modelMapper.map(userRequest,AppUser.class);
        user.setRole(Role.APP_USER);
        appUserRepository.save(user);
    }

    @Override
    public List<UserResponse> getAllAppUsers() {
        return appUserRepository.findAll().stream()
                .map(user -> modelMapper.map(user,UserResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserById(String id) {
        AppUser user = appUserRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("AppUser not found with ID :" +id));
        return modelMapper.map(user,UserResponse.class);
    }

    @Override
    public void updateUser(UserRequest userRequest,String id) {
        AppUser user = appUserRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("AppUser not found with ID :" +id));
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        userRepository.save(user);
    }
}
