package com.santt4na.spring_role_guard.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.santt4na.spring_role_guard.model.User;

import lombok.Getter;

@Getter
public class CustomUserDetails implements UserDetails {

  private final User user;

  public CustomUserDetails(User user) {
    this.user = user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return user.getAccessRoles()
        .stream()
        .map(role -> new SimpleGrantedAuthority(role.getName()))
        .collect(Collectors.toList());
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getUsername();
  }

  @Override
  public boolean isAccountNonLocked() {
    // Logica para verificar se a conta esta bloqueada
    return true;
  }

  @Override
  public boolean isAccountNonExpired() {
    // Logica para verificar se a conta esta expirada
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    // Logica para verificar se a senha esta expiradas
    return true;
  }

  @Override
  public boolean isEnabled() {
    // Logica para verificar se a conta esta ativo
    return user.isEnabled();
  }

}
