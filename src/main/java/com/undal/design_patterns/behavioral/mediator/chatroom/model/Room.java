package com.undal.design_patterns.behavioral.mediator.chatroom.model;

import com.undal.design_patterns.behavioral.mediator.chatroom.Util;

public class Room {
    private final String roomId;
    private String roomName;
    Util util = new Util();
    public Room(String roomName) {
        roomId = util.getId();
        this.roomName = roomName;
    }

    public String getUserId() {
        return roomId;
    }

    public String getUsername() {
        return roomName;
    }

    public void setUsername(String roomName) {
        this.roomName = roomName;
    }
}
