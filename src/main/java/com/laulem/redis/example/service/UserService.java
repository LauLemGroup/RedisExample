package com.laulem.redis.example.service;

import com.laulem.redis.example.model.User;
import com.laulem.redis.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;


    @Cacheable(value = "findAllCache")
    public List<User> findAll() {
        System.out.println("findAllCache not called");
        return this.userRepository.findAll();
    }

    public void save(User user) {
        this.userRepository.save(user);
    }

    public Long count() {
        return this.userRepository.count();
    }
}
