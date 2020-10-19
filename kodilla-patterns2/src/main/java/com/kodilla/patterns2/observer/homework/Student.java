package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Student implements Observable {
    private final List<Observer> observers;
    private final List<String> messages;
    private final String name;
    private final String group;

    public Student(String name, String group) {
        this.observers = new ArrayList<>();
        messages = new ArrayList<>();
        this.name = name;
        this.group = group;
    }

    public void sendTask(String task) {
        messages.add(task);
        notifyObserver();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObserver() {
        for(Observer observer : observers) {
            observer.update(this);
        }
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public List<String> getMessages() {
        return messages;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

}
