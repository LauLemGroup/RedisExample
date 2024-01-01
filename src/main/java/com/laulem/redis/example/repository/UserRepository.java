package com.laulem.redis.example.repository;

import com.laulem.redis.example.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    List<User> findAll();
}
