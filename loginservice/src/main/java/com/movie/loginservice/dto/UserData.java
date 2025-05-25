package com.movie.loginservice.dto;

public class UserData {
	private Integer id;
    private String email;
    private String name;
    private String phone;
    private String role;

    // Constructor to initialize the UserData
    public UserData(Integer id,String email, String name, String phone, String role) {
    	this.id = id;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.role = role;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
