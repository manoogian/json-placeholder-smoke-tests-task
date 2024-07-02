package com.JsonPlaceholder.model;

public class User {

    private final Integer userId;
    private final String email;

    public User(Integer userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }
}
