package com.santt4na.spring_role_guard.config;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.santt4na.spring_role_guard.model.AccessRole;
import com.santt4na.spring_role_guard.model.User;
import com.santt4na.spring_role_guard.repository.AccessRoleRepository;
import com.santt4na.spring_role_guard.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {
  private final UserRepository userRepository;
  private final AccessRoleRepository accessRoleRepository;
  private final PasswordEncoder passwordEncoder;

  public DataInitializer(
      UserRepository userRepository,
      AccessRoleRepository accessRoleRepository,
      PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.accessRoleRepository = accessRoleRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @PostConstruct
  public void init() {
    createRoleIfNotExists("ROLE_ADMIN");
    createRoleIfNotExists("ROLE_MERCHANT");
    createRoleIfNotExists("ROLE_CUSTOMER");
    createRoleIfNotExists("ROLE_MOTOBOY");

    createUser("Admin", "admin@teste.com", "admin", "senha123", Set.of("ROLE_ADMIN"));
    createUser("Merchant", "merchant@teste.com", "merchant", "senha123", Set.of("ROLE_MERCHANT"));
    createUser("Customer", "customer@teste.com", "customer", "senha123", Set.of("ROLE_CUSTOMER"));
    createUser("Motoboy", "motoboy@teste.com", "motoboy", "senha123", Set.of("ROLE_MOTOBOY"));
  }

  private void createRoleIfNotExists(String roleName) {
    if (!accessRoleRepository.existsByName(roleName)) {
      AccessRole role = new AccessRole();
      role.setName(roleName);
      accessRoleRepository.save(role);
    }
  }

  private void createUser(String name, String email, String username,
      String password, Set<String> roleNames) {
    if (!userRepository.existsByUsername(username)) {
      User user = new User();
      user.setName(name);
      user.setEmail(email);
      user.setUsername(username);
      user.setPassword(passwordEncoder.encode(password));
      user.setIsBlocked(false);

      // Correção: Removida a duplicação do prefixo ROLE_
      Set<AccessRole> accessRoles = roleNames.stream()
          .map(roleName -> accessRoleRepository.findByName(roleName))
          .filter(Optional::isPresent)
          .map(Optional::get)
          .collect(Collectors.toSet());

      user.setAccessRoles(accessRoles);
      userRepository.save(user);
    }
  }
}