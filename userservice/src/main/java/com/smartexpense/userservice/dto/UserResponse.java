package com.smartexpense.userservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponse { // The output to the user for their registerRequest
    private Long id;
    private String email;

    @JsonIgnore
    private String password;

    private String firstname;
    private String lastname;
    private String currency;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
