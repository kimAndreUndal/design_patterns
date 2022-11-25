package com.undal.design_patterns.behavioral.observer.example;

public class MyTopicSubscriber implements Observer{
    private final String name;
    private Subject topic;

    MyTopicSubscriber(String name){
        this.name = name;
    }


    @Override
    public void update() {
        String message = (String) topic.getUpdate(this);
        if (message == null) System.out.printf(name, ":: No new message");
        else System.out.printf(name, ":: Consuming message: ", message);
    }

    @Override
    public void setSubject(Subject subject) {
        this.topic = subject;
    }
}
