package com.bikeridersupport.buddyfinder.controller;

import com.bikeridersupport.buddyfinder.model.BuddyUser;
import com.bikeridersupport.buddyfinder.model.dto.BuddyRequest;
import com.bikeridersupport.buddyfinder.model.dto.BuddyResponse;
import com.bikeridersupport.buddyfinder.service.impl.BuddyServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buddy")
@RequiredArgsConstructor
public class BuddyController {
    private final BuddyServiceImpl buddyService;

    @PostMapping()
    public ResponseEntity<String> createBuddy(@RequestBody @Valid BuddyRequest buddyRequest){
        buddyService.saveBuddy(buddyRequest);
        return new ResponseEntity<>("Buddy created Successfully", HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<BuddyResponse>> getAlBuddy(){
        return new ResponseEntity<>(buddyService.getAllBuddy(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuddyResponse> getBuddyById(@PathVariable @Valid String id){
        return new ResponseEntity<>(buddyService.getBuddyById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBuddyById(@RequestBody BuddyRequest buddyRequest,
                                                 @PathVariable @Valid String id){
        //buddyRequest.updateBuddy(buddyRequest,id);
        return new ResponseEntity<>("User updated successfully",HttpStatus.OK);
    }
    @GetMapping("/profile")
    @PreAuthorize("hasRole('BUDDY')")
    public ResponseEntity<BuddyUser> getProfile(@AuthenticationPrincipal BuddyUser currentBuddy) {
        return ResponseEntity.ok(currentBuddy);
    }
}
