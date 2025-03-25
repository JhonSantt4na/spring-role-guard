package com.santt4na.spring_role_guard.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.santt4na.spring_role_guard.dto.UserDto;
import com.santt4na.spring_role_guard.model.User;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  User toEntity(UserDto userDto);

  UserDto toDto(User user);
}
