package com.undal.design_patterns.behavioral.mediator.chatroom;

import java.util.UUID;

public class Util {

    public String getId(){
        return UUID.randomUUID().toString();
    }
}
