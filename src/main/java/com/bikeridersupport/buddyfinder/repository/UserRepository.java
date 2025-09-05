package com.bikeridersupport.buddyfinder.repository;

import com.bikeridersupport.buddyfinder.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
