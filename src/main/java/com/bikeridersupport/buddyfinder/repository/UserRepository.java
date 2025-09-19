package com.bikeridersupport.buddyfinder.repository;

import com.bikeridersupport.buddyfinder.model.AppUser;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface UserRepository extends MongoRepository<AppUser, String> {
    AppUser findByUsername(String username);
    AppUser findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
