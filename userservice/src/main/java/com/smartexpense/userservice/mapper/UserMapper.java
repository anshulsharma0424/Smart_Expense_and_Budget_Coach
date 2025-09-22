package com.smartexpense.userservice.mapper;

import com.smartexpense.userservice.dto.RegisterUserRequest;
import com.smartexpense.userservice.dto.UserResponse;
import com.smartexpense.userservice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static User toUserEntity (RegisterUserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setFirstname(userRequest.getFirstname());
        user.setLastname(userRequest.getLastname());
        user.setCurrency(userRequest.getCurrency());

        return user;
    }

    public static UserResponse toUserResponse (User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setPassword(user.getPassword());
        userResponse.setFirstname(user.getFirstname());
        userResponse.setLastname(user.getLastname());
        userResponse.setCurrency(user.getCurrency());
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setUpdatedAt(user.getUpdatedAt());

        return userResponse;
    }
}
