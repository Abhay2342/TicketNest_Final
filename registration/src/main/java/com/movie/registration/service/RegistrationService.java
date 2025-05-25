package com.movie.registration.service;

import com.movie.registration.entity.User;
import com.movie.registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class RegistrationService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already registered.");
        }
        user.setCreatedAt(LocalDateTime.now());
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Hash the password
        return userRepository.save(user);
    }

    private void generateAndSendOTP(User user) {
        String otpCode = String.valueOf(ThreadLocalRandom.current().nextInt(100000, 999999));
        // Logic to save OTP in the database and send it via email or SMS
    }

    // Additional methods for OTP verification...
}