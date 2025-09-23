package com.smartexpense.userservice.controller;

import com.smartexpense.userservice.dto.LoginResponse;
import com.smartexpense.userservice.dto.LoginUserRequest;
import com.smartexpense.userservice.dto.RegisterUserRequest;
import com.smartexpense.userservice.dto.UserResponse;
import com.smartexpense.userservice.service.AuthService;
import com.smartexpense.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final AuthService authService;

    // Constructor injection of UserService, AuthService
    public UserController(UserService userService,  AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    // ============================= End Points =============================

    // 1. Register user
    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser (@Valid @RequestBody RegisterUserRequest registerUserRequest){
        return ResponseEntity.ok(userService.registerUser(registerUserRequest));
    }

    // 2. Login user
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser (@Valid @RequestBody LoginUserRequest loginUserRequest){
        return ResponseEntity.ok(authService.login(loginUserRequest));
    }

    // 3. Get all users
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers (){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // 4. Get user by id
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserById (@PathVariable Long userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    // Validate user
    @GetMapping("/{userId}/validate")
    public ResponseEntity<Boolean> validateUser(@PathVariable Long userId){
        return ResponseEntity.ok(userService.existsByUserId((userId)));
    }
}
