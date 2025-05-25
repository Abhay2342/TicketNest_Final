package com.movie.otpverificationservice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "OTP_Verifications")
public class OTP {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    
    @Column(name = "expires_at") 
    private LocalDateTime expiresAt;
    
    @Column(name = "created_at") 
    private LocalDateTime createdAt;
    
    @Column(name = "is_verified")
    private Integer isVerified;
    
    @Column(name = "otp_code") 
    private String otpCode;
    
    @Column(name = "user_id")
    private Integer userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDateTime getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(LocalDateTime expiresAt) {
		this.expiresAt = expiresAt;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Integer isVerified) {
		this.isVerified = isVerified;
	}

	public String getOtpCode() {
		return otpCode;
	}

	public void setOtpCode(String otpCode) {
		this.otpCode = otpCode;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
    // Getters and Setters
}