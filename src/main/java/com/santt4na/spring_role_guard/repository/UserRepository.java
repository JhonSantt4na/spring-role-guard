package com.santt4na.spring_role_guard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santt4na.spring_role_guard.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
