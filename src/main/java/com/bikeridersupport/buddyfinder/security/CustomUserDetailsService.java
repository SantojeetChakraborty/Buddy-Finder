package com.bikeridersupport.buddyfinder.security;

import com.bikeridersupport.buddyfinder.model.AppUser;
import com.bikeridersupport.buddyfinder.model.BuddyUser;
import com.bikeridersupport.buddyfinder.repository.BuddyRepository;
import com.bikeridersupport.buddyfinder.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository appUserRepository;
    private final BuddyRepository buddyRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username);
        if(appUser != null){
            return appUser;
        }
        BuddyUser buddyUser = buddyRepository.findByUsername(username);
        if(buddyUser != null){
            return buddyUser;
        }

        throw new UsernameNotFoundException("User not found with username : "+username);
    }

    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByEmail(email);
        if (appUser != null) {
            return appUser;
        }

        BuddyUser buddyUser = buddyRepository.findByEmail(email);
        if (buddyUser != null) {
            return buddyUser;
        }

        throw new UsernameNotFoundException("User not found with email: " + email);
    }
}
