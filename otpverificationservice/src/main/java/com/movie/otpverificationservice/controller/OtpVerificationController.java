package com.movie.otpverificationservice.controller;

import com.movie.otpverificationservice.entity.OTP;
import com.movie.otpverificationservice.service.OtpVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/otp")
public class OtpVerificationController {

    @Autowired
    private OtpVerificationService otpVerificationService;

    @PostMapping
    public ResponseEntity<OTP> addOtp(@RequestBody OTP otp) {
        return ResponseEntity.ok(otpVerificationService.addOtp(otp));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OTP> updateOtp(@PathVariable Integer id, @RequestBody OTP otp) {
        return ResponseEntity.ok(otpVerificationService.updateOtp(id, otp));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOtp(@PathVariable Integer id) {
    	otpVerificationService.deleteOtp(id);
        return ResponseEntity.ok("OTP deleted successfully.");
    }

    @GetMapping
    public ResponseEntity<List<OTP>> getAllOtps() {
        return ResponseEntity.ok(otpVerificationService.getAllOtps());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OTP> getOtpById(@PathVariable Integer id) {
        return ResponseEntity.ok(otpVerificationService.getOtpById(id));
    }
}