package com.undal.design_patterns.behavioral.mediator.chatroom.model;

import com.undal.design_patterns.behavioral.mediator.chatroom.Util;

public class AppUser {
    private String userId;
    private String username;
    Util util = new Util();

    public AppUser(String username) {
        userId = util.getId();
        this.username = username;
    }

    public AppUser(String userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public AppUser() {

    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
