package com.laulem.redis.example.repository;

import com.laulem.redis.example.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private static final List<User> users = new ArrayList<>();

    public List<User> findAll() {
        System.out.println("UserRepository::findAll method called");
        return users;
    }

    public User findById(final Long userId) {
        System.out.println("UserRepository::findById method called");
        return users.stream().filter(x -> x.getId().equals(userId)).findFirst().orElse(null);
    }

    public User save(final User user) {
        System.out.println("UserRepository::save method called");
        user.setId(users.stream().mapToLong(User::getId).max().orElse(0) + 1);
        users.add(user);
        return user;
    }

    public void deleteById(final Long userId) {
        System.out.println("UserRepository::deleteById method called");
        final Optional<User> userToRemove = users.stream().filter(x -> x.getId().equals(userId)).findFirst();
        if (userToRemove.isPresent()) {
            users.remove(userToRemove.get());
        }
    }

    public Long count() {
        System.out.println("UserRepository::count method called");
        return (long) users.size();
    }
}
