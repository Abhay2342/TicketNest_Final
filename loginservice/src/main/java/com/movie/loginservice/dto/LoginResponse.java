package com.movie.loginservice.dto;

public class LoginResponse {
    private String message;
    private UserData userData;
    private Integer statusCode;

    // Constructor for success case
    public LoginResponse(UserData userData, String message, Integer statusCode) {
        this.userData = userData;
        this.message = message;
        this.statusCode = statusCode;
    }

    // Constructor for error cases
    public LoginResponse(String message, UserData userData, Integer statusCode) {
        this.message = message;
        this.userData = userData;
        this.statusCode = statusCode;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
