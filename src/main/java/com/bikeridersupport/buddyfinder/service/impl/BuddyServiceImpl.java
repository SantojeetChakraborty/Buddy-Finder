package com.bikeridersupport.buddyfinder.service.impl;

import com.bikeridersupport.buddyfinder.model.BuddyUser;
import com.bikeridersupport.buddyfinder.model.dto.BuddyRequest;
import com.bikeridersupport.buddyfinder.model.dto.BuddyResponse;
import com.bikeridersupport.buddyfinder.repository.BuddyRepository;
import com.bikeridersupport.buddyfinder.service.BuddyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BuddyServiceImpl implements BuddyService {
    private final ModelMapper modelMapper;
    private final BuddyRepository buddyRepository;

    @Override
    public void saveBuddy(BuddyRequest buddyRequest) {
        buddyRepository.save(modelMapper.map(buddyRequest, BuddyUser.class));
    }

    @Override
    public BuddyResponse getBuddyById(String id) {
        BuddyUser buddyUser = buddyRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Buddy not found with ID :"+id));
        return modelMapper.map(buddyUser,BuddyResponse.class);
    }

    @Override
    public List<BuddyResponse> getAllBuddy() {
        return buddyRepository.findAll().stream()
                .map(buddyUser ->modelMapper.map(buddyUser, BuddyResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public void updateBuddyById(BuddyRequest buddyRequest, String id) {
        BuddyUser buddyUser = buddyRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Buddy not found with ID :" +id));
        buddyUser.setUsername(buddyRequest.getUsername());
        buddyUser.setEmail(buddyRequest.getEmail());
        buddyUser.setPassword(buddyRequest.getPassword());
        buddyRepository.save(buddyUser);
    }
}
