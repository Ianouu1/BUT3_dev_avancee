package com.example.but3_dev_avancee.model;

import lombok.Getter;
import lombok.Setter;

public class UserBean {
    @Getter
    private String username;
    private String password;
    @Setter
    @Getter
    private String attribute2;
    @Setter
    @Getter
    private String attribute3;

    public UserBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        return "a".equals(username) && "a".equals(password);
    }
}
