package com.laulem.redis.example.mapper;

import com.laulem.redis.example.dto.UserDto;
import com.laulem.redis.example.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User mapToUser(UserDto userDto);

    UserDto mapToUserDto(User user);
}
