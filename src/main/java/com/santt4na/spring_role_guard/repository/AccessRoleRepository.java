package com.santt4na.spring_role_guard.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santt4na.spring_role_guard.model.AccessRole;

@Repository
public interface AccessRoleRepository extends JpaRepository<AccessRole, Long> {
    boolean existsByName(String name);

    Optional<AccessRole> findByName(String name);
}
