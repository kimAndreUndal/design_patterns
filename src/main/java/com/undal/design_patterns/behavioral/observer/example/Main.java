package com.undal.design_patterns.behavioral.observer.example;

//digitalocean.com/community/tutorials/observer-design-pattern-in-java
public class Main {
    public static void main(String[] args) {
        //Create subject
        MyTopic topic = new MyTopic();

        //Create observers;
        Observer observer1 = new MyTopicSubscriber("object1");
        Observer observer2 = new MyTopicSubscriber("object2");
        Observer observer3 = new MyTopicSubscriber("object3");

        //Register observers to the subject
        topic.register(observer1);
        topic.register(observer2);
        topic.register(observer3);


        //Attach observer to subject
        observer1.setSubject(topic);
        observer2.setSubject(topic);
        observer3.setSubject(topic);

        topic.unRegister(observer3);
        //Check if any update is available
        observer1.update();


        //now send message to the subject
        topic.postMessage("this is a message!");
    }
}
