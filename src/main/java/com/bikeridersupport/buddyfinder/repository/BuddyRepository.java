package com.bikeridersupport.buddyfinder.repository;

import com.bikeridersupport.buddyfinder.model.BuddyUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BuddyRepository extends MongoRepository<BuddyUser,String> {
}
