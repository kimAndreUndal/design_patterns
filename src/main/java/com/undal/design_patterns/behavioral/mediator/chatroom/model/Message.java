package com.undal.design_patterns.behavioral.mediator.chatroom.model;

import java.util.Date;

public class Message {

    private final AppUser appUser;
    private final Room room;

    private String message;

    private final Date messageSent;
    public Message(AppUser appUser, Room room, String message, Date messageSent) {
        this.appUser = appUser;
        this.room = room;
        this.message = message;
        this.messageSent = messageSent;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public Room getRoom() {
        return room;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getMessageSent() {
        return messageSent;
    }
}
