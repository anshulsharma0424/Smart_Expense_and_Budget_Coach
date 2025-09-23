package com.smartexpense.ledgerservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userservice", url = "http://localhost:8081/api/users")
public interface UserClient {

    @GetMapping("/{userId}/validate")
    Boolean validateUser(@PathVariable Long userId);
}
