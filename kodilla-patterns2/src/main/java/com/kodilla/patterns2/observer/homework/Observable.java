package com.kodilla.patterns2.observer.homework;

public interface Observable {

    public void registerObserver(Observer observer);
    public void notifyObserver();
    public void removeObserver(Observer observer);

}
