package com.laulem.redis.example.controller;

import com.laulem.redis.example.dto.UserDto;
import com.laulem.redis.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public UserDto findById(@PathVariable final Long userId) {
        return userService.findById(userId);
    }

    @GetMapping("/count")
    public Long count() {
        return userService.count();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable() final Long id) {
        userService.delete(id);
    }

    @PostMapping(value = "/users")
    public UserDto save(@RequestBody final UserDto userDto) {
        return userService.save(userDto);
    }
}
