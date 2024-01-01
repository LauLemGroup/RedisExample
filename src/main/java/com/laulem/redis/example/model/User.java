package com.laulem.redis.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@Builder
@RedisHash("User")
public class User implements Serializable {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
}