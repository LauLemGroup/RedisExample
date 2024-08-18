package com.laulem.redis.example.service;

import com.laulem.redis.example.dto.UserDto;
import com.laulem.redis.example.mapper.UserMapper;
import com.laulem.redis.example.model.User;
import com.laulem.redis.example.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserService {
    private static final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Cacheable(value = "userItems")
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(userMapper::mapToUserDto).collect(Collectors.toCollection(ArrayList::new));
    }

    @Cacheable(value = "user", key = "'user:' + #userId", unless = "#result == null")
    public UserDto findById(final Long userId) {
        Objects.requireNonNull(userId);
        return userMapper.mapToUserDto(userRepository.findById(userId));
    }

    public UserDto save(final UserDto userDto) {
        Objects.requireNonNull(userDto);
        return userMapper.mapToUserDto(userRepository.save(userMapper.mapToUser(userDto)));
    }

    @Caching(evict = {
            @CacheEvict(value = "userItems", allEntries = true),
            @CacheEvict(value = "user", key = "'user:' + #userId")
    })
    public void delete(final Long userId) {
        Objects.requireNonNull(userId);
        userRepository.deleteById(userId);
    }

    public Long count() {
        return userRepository.count();
    }
}
