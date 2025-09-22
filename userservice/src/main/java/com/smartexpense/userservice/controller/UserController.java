package com.smartexpense.userservice.controller;

import com.smartexpense.userservice.dto.RegisterUserRequest;
import com.smartexpense.userservice.dto.UserResponse;
import com.smartexpense.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // Constructor injection of UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ============================= End Points =============================

    // 1. Register user
    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser (@Valid @RequestBody RegisterUserRequest registerUserRequest){
        return ResponseEntity.ok(userService.registerUser(registerUserRequest));
    }

    // 2. Get all users
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers (){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // 3. Get user by id
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserById (@PathVariable Long userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }
}
