package com.undal.design_patterns.behavioral.observer.example;

import java.util.ArrayList;
import java.util.List;


public class MyTopic implements Subject{

    private final List<Observer> observers;
    private String message;
    private boolean changed;
    private final Object MUTEX = new Object();

    public MyTopic() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        if(observer == null) throw new NullPointerException();
        synchronized (MUTEX){
            if(!observers.contains(observer)) observers.add(observer);
        }
    }

    @Override
    public void unRegister(Observer observer) {
        synchronized (MUTEX) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersLocal;
        //Synchronization is used to make sure any observer registered after message is received is not notified
        synchronized (MUTEX){
            if(!changed)return;
            observersLocal = List.copyOf(this.observers);
            this.changed = false;
        }
        observersLocal.forEach(Observer::update);
    }

    @Override
    public Object getUpdate(Observer observer) {
        return this.message;
    }

    public void postMessage(String message){
        System.out.printf(" Message Posted to Topic %s%n ", message);
        this.message = message;
        this.changed = true;
        notifyObservers();
    }
}
