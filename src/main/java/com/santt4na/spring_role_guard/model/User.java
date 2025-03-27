package com.santt4na.spring_role_guard.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String email;
  private String name;
  private String username;
  private String password;
  private Boolean isBlocked;

  @ManyToMany(fetch = FetchType.EAGER)
  private Set<AccessRole> accessRoles = new HashSet<>();

  public boolean isEnabled() {
    // Supondo que isBlocked = false significa conta ativa
    return !Boolean.TRUE.equals(isBlocked);
  }
}
