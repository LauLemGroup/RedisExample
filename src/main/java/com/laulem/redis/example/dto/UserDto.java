package com.laulem.redis.example.dto;

import java.io.Serializable;

public class UserDto implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
}