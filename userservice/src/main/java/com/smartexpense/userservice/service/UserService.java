package com.smartexpense.userservice.service;

import com.smartexpense.userservice.dto.RegisterUserRequest;
import com.smartexpense.userservice.dto.UserResponse;
import com.smartexpense.userservice.entity.User;
import com.smartexpense.userservice.exception.UserAlreadyExistException;
import com.smartexpense.userservice.exception.UserNotFoundException;
import com.smartexpense.userservice.mapper.UserMapper;
import com.smartexpense.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Constructor injection of UserRepository
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Register a new user
    public UserResponse registerUser(RegisterUserRequest registerRequest) {
        // Check that the user must not already exist in the database.
        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new UserAlreadyExistException("User with email: " + registerRequest.getEmail() + " already exists!");
        }

        User user = UserMapper.toUserEntity(registerRequest); // convert request to entity
        User savedUser = userRepository.save(user); // save user entity in database
        return UserMapper.toUserResponse(savedUser); // convert user entity to response and return it
    }

    // Get all users
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::toUserResponse)
                .collect(Collectors.toList());
    }

    // Get user by userId
    public UserResponse getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with UserID: " + userId + " doesn't exist."));
        return UserMapper.toUserResponse(user);
    }
}
