package com.movie.loginservice.service;

import com.movie.loginservice.dto.LoginResponse;
import com.movie.loginservice.dto.UserData;
import com.movie.loginservice.entity.User;
import com.movie.loginservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginResponse login(String email, String password) {
        // Find user by email
        User user = userRepository.findByEmail(email);
        if (user != null) {
            // Check the password match
            if (passwordEncoder.matches(password, user.getPassword())) {
                // User found and password matches, return user data with null token
                return new LoginResponse(
                        new UserData(user.getId(), user.getEmail(), user.getName(), user.getPhone(), user.getRole()), 
                        null,
                        HttpStatus.OK.value()
                );
            } else {
                // Password mismatch
                return new LoginResponse("Invalid password", null, HttpStatus.UNAUTHORIZED.value());
            }
        } else {
            // User not found
            return new LoginResponse("User not found", null, HttpStatus.NOT_FOUND.value());
        }
    }
}
