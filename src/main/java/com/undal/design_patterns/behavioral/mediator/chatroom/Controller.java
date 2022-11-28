package com.undal.design_patterns.behavioral.mediator.chatroom;

import com.undal.design_patterns.behavioral.mediator.chatroom.db.DatabaseHandler;
import com.undal.design_patterns.behavioral.mediator.chatroom.model.AppUser;

public class Controller {
    private final DatabaseHandler databaseHandler;

    public Controller(DatabaseHandler databaseHandler) {
        this.databaseHandler = databaseHandler;
    }

    public boolean addUser(AppUser appUser){
        return false;
    }
}
