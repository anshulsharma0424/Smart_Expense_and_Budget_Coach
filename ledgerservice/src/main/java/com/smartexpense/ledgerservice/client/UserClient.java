package com.smartexpense.ledgerservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userservice")
public interface UserClient {

    @GetMapping("/api/users/{userId}/validate")
    Boolean validateUser(@PathVariable("userId") Long userId);
}
