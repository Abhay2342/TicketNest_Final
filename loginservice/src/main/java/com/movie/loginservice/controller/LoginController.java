package com.movie.loginservice.controller;

import com.movie.loginservice.dto.LoginRequest;
import com.movie.loginservice.dto.LoginResponse;
import com.movie.loginservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest request) {
        LoginResponse loginResponse = loginService.login(request.getEmail(), request.getPassword());

        // Wrap the response inside a "data" field to maintain consistency
        return ResponseEntity
                .status(loginResponse.getStatusCode())
                .body(Collections.singletonMap("data", loginResponse));
    }
}
