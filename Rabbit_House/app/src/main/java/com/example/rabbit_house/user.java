package com.example.rabbit_house;

import java.io.Serializable;

public class user implements Serializable {
    private String username="admin";
    private String password="123";

    public user() {
    }

    public user(String username, String pass) {
        this.username=username;
        this.password=pass;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "user{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
