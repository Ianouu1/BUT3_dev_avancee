package com.example.but3_dev_avancee;

import lombok.Getter;
import lombok.Setter;

public class User {
    @Getter
    private String username;
    private String password;
    @Setter
    @Getter
    private String attribute2;
    @Setter
    @Getter
    private String attribute3;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        return "a".equals(username) && "a".equals(password);
    }
}
