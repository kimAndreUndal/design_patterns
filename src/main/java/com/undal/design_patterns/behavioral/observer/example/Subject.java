package com.undal.design_patterns.behavioral.observer.example;

public interface Subject {

    //Methods to register and unregister observers
    void register(Observer observer);
    void unRegister(Observer observer);

    //Method to notify observers of change
    void notifyObservers();

    //Method to get updates from subject
    Object getUpdate(Observer observer);
}
