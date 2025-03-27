package com.santt4na.spring_role_guard.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santt4na.spring_role_guard.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

  boolean existsByUsername(String username);

  Optional<User> findByUsername(String username);
}