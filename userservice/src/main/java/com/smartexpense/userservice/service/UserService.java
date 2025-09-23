package com.smartexpense.userservice.service;

import com.smartexpense.userservice.dto.RegisterUserRequest;
import com.smartexpense.userservice.dto.UserResponse;
import com.smartexpense.userservice.entity.User;
import com.smartexpense.userservice.exception.UserAlreadyExistException;
import com.smartexpense.userservice.exception.UserNotFoundException;
import com.smartexpense.userservice.mapper.UserMapper;
import com.smartexpense.userservice.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    // Constructor injection of UserRepository, UserMapper, PasswordEncoder
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    // Register a new user
    public UserResponse registerUser(RegisterUserRequest registerRequest) {
        // Check that the user must not already exist in the database.
        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new UserAlreadyExistException("User with email: " + registerRequest.getEmail() + " already exists!");
        }

        User user = userMapper.toUserEntity(registerRequest); // convert request to entity
        User savedUser = userRepository.save(user); // save user entity in database
        return userMapper.toUserResponse(savedUser); // convert user entity to response and return it
    }

    // Get all users
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::toUserResponse)
                .collect(Collectors.toList());
    }

    // Get user by userId
    public UserResponse getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with UserID: " + userId + " doesn't exist."));
        return userMapper.toUserResponse(user);
    }

    public Boolean existsByUserId(Long userId) {
        return userRepository.existsById(userId);
    }
}
