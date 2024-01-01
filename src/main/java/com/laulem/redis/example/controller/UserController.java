package com.laulem.redis.example.controller;

import com.laulem.redis.example.model.User;
import com.laulem.redis.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("/count")
    public Long getCount() {
        return userService.count();
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping(value = "/users")
    public void save(@RequestBody final User user) {
        userService.save(user);
    }
}
