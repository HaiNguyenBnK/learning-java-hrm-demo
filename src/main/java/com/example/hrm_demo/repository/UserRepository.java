package com.example.hrm_demo.repository;

import com.example.hrm_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  // You can add custom queries here, like findByUsername for authentication purposes
  User findByUsername(String username);
}
