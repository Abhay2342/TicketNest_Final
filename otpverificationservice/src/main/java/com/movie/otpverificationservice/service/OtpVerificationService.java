package com.movie.otpverificationservice.service;

import com.movie.otpverificationservice.entity.OTP;
import com.movie.otpverificationservice.repository.OtpVerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OtpVerificationService {

    @Autowired
    private OtpVerificationRepository otpVerificationRepository;

    public OTP addOtp(OTP otp) {
        LocalDateTime now = LocalDateTime.now();
        otp.setCreatedAt(now);
        otp.setExpiresAt(now.plusDays(7)); // Set expiresAt to 7 days from now
        return otpVerificationRepository.save(otp); // Save new otp
    }


    public OTP updateOtp(Integer id, OTP otpDetails) {
        OTP otp = otpVerificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OTP not found with id " + id));

        otp.setCreatedAt(otpDetails.getCreatedAt());
        otp.setExpiresAt(otpDetails.getExpiresAt());
        otp.setIsVerified(otpDetails.getIsVerified());
        otp.setOtpCode(otpDetails.getOtpCode());
        otp.setUserId(otpDetails.getUserId());
        return otpVerificationRepository.save(otp); // Save updated movie
    }

    public void deleteOtp(Integer id) {
        OTP otp = otpVerificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OTP not found with id " + id));
        otpVerificationRepository.delete(otp); // Delete movie
    }

    public List<OTP> getAllOtps() {
        return otpVerificationRepository.findAll(); // Retrieve all movies
    }

    public OTP getOtpById(Integer id) {
        return otpVerificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OTP not found with id " + id)); // Find by ID
    }
}