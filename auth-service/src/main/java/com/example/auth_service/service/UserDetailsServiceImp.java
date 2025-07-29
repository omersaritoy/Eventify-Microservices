package com.example.auth_service.service;

import com.example.auth_service.client.UserClient;
import com.example.auth_service.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
    private final UserClient userClient;

    public UserDetailsServiceImp(UserClient userClient) {
        this.userClient = userClient;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ResponseEntity<UserResponse> response = userClient.getUserByEmail(email);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            UserResponse user = response.getBody();

            return org.springframework.security.core.userdetails.User
                    .withUsername(user.email())
                    .password(user.password())
                    .authorities(String.valueOf(user.role()))
                    .build();
        }

        throw new UsernameNotFoundException("User not found with email: " + email);
    }
}
