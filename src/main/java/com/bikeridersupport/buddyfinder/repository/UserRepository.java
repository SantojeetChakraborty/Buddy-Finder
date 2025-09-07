package com.bikeridersupport.buddyfinder.repository;

import com.bikeridersupport.buddyfinder.model.AppUser;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface UserRepository extends MongoRepository<AppUser, String> {
    Optional<AppUser> findByEmail(String email);
}
