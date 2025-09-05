package com.bikeridersupport.buddyfinder.service.impl;

import com.bikeridersupport.buddyfinder.model.BaseUser;
import com.bikeridersupport.buddyfinder.model.Buddy;
import com.bikeridersupport.buddyfinder.model.dto.BuddyRequest;
import com.bikeridersupport.buddyfinder.model.dto.BuddyResponse;
import com.bikeridersupport.buddyfinder.repository.BuddyRepository;
import com.bikeridersupport.buddyfinder.repository.UserRepository;
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
        buddyRepository.save(modelMapper.map(buddyRequest, Buddy.class));
    }

    @Override
    public BuddyResponse getBuddyById(String id) {
        Buddy buddy = buddyRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Buddy not found with ID :"+id));
        return modelMapper.map(buddy,BuddyResponse.class);
    }

    @Override
    public List<BuddyResponse> getAllBuddy() {
        return buddyRepository.findAll().stream()
                .map(buddy->modelMapper.map(buddy, BuddyResponse.class))
                .collect(Collectors.toList());
    }
}
