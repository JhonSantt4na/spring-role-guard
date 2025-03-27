package com.santt4na.spring_role_guard.mappers;

import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.santt4na.spring_role_guard.dto.AccessRoleDto;
import com.santt4na.spring_role_guard.dto.UserDto;
import com.santt4na.spring_role_guard.model.AccessRole;
import com.santt4na.spring_role_guard.model.User;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  @Mapping(target = "accessRoles", source = "accessRoles")
  User toEntity(UserDto userDto);

  @Mapping(target = "accessRoles", source = "accessRoles")
  UserDto toDto(User user);

  // Mapeamento de AccessRole para AccessRoleDto e vice-versa
  default Set<AccessRole> mapAccessRoleDtosToEntities(Set<AccessRoleDto> dtos) {
    return dtos.stream()
        .map(dto -> new AccessRole(dto.getId(), "ROLE_" + dto.getName())) // Adiciona prefixo ROLE_
        .collect(Collectors.toSet());
  }

  default Set<AccessRoleDto> mapAccessRolesToDtos(Set<AccessRole> entities) {
    return entities.stream()
        .map(entity -> new AccessRoleDto(entity.getId(), entity.getName().replace("ROLE_", "")))
        .collect(Collectors.toSet());
  }
}
