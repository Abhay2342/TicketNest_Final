package com.movie.otpverificationservice.repository;

import com.movie.otpverificationservice.entity.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtpVerificationRepository extends JpaRepository<OTP, Integer> {
    // Additional query methods can be defined here
}