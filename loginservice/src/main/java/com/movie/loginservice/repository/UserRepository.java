package com.movie.loginservice.repository;

import com.movie.loginservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    boolean existsByEmail(String email); // Check if the email already exists
}