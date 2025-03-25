package com.santt4na.spring_role_guard.dto;

import java.util.Set;

import lombok.Data;

@Data
public class UserDto {
  private Long id;
  private String email;
  private String name;
  private String password;
  private String username;
  private Boolean isBlocked;
  private Set<AccessRoleDto> accessRoles;
}