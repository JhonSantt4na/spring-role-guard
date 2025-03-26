package com.santt4na.spring_role_guard.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.santt4na.spring_role_guard.dto.UserDto;
import com.santt4na.spring_role_guard.exception.UserNotFoundException;
import com.santt4na.spring_role_guard.mappers.UserMapper;
import com.santt4na.spring_role_guard.model.User;
import com.santt4na.spring_role_guard.repository.UserRepository;

@Service
public class UserService {

  private UserRepository repository;
  private UserMapper mapper;

  public UserDto createUser(UserDto userDto) {
    User user = new User();
    user.setName(userDto.getName());
    user.setEmail(userDto.getEmail());
    user.setPassword(userDto.getPassword());
    user.setUsername(userDto.getUsername());
    user.setIsBlocked(userDto.getIsBlocked());

    User savedUser = repository.save(user);
    return mapper.toDto(savedUser);
  }

  public UserDto updateUser(Long id, UserDto userDto) {
    User user = repository.findById(id)
        .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));

    user.setName(userDto.getName());
    user.setEmail(userDto.getEmail());
    user.setUsername(userDto.getUsername());
    user.setIsBlocked(userDto.getIsBlocked());

    User updatedUser = repository.save(user);
    return mapper.toDto(updatedUser);
  }

  public UserService(UserRepository repository, UserMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public List<UserDto> findAllUsers() {
    List<User> users = repository.findAll();
    return users.stream().map(mapper::toDto).collect(Collectors.toList());
  }

  public Optional<UserDto> findUserDtoById(Long id) {
    return repository.findById(id)
        .map(mapper::toDto);
  }

  public void deleteUser(Long id) {
    User user = repository.findById(id)
        .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
    repository.delete(user);
  }
}
