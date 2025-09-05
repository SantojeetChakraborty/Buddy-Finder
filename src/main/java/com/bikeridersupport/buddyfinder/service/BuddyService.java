package com.bikeridersupport.buddyfinder.service;

import com.bikeridersupport.buddyfinder.model.dto.BuddyRequest;
import com.bikeridersupport.buddyfinder.model.dto.BuddyResponse;

import java.util.List;

public interface BuddyService {
    void saveBuddy(BuddyRequest buddyRequest);
    BuddyResponse getBuddyById(String id);
    List<BuddyResponse> getAllBuddy();
}
