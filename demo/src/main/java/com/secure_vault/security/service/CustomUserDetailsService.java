package com.secure_vault.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.secure_vault.model.User;
import com.secure_vault.repository.IUserRepository;
import com.secure_vault.security.CustomUserDetails;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class CustomUserDetailsService implements UserDetailsService {
    
    private final IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail()
            .orElseThrow(() -> new UsernameNotFoundException("User not found" + username));
        return new CustomUserDetails(user);
    }

}
