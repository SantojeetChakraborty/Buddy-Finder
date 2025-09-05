package com.bikeridersupport.buddyfinder.repository;

import com.bikeridersupport.buddyfinder.model.Buddy;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BuddyRepository extends MongoRepository<Buddy,String> {
}
