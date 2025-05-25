package com.movie.registration.controller;

import com.movie.registration.entity.User;
import com.movie.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        try {
            User registeredUser = registrationService.registerUser(user);
            return ResponseEntity.ok(registeredUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null); // Error handling
        }
    }

    // Endpoint for OTP verification
}