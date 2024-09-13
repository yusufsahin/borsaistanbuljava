package designpatterns;

import models.Stock;
import java.util.ArrayList;
import java.util.List;

public class Subject {
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(Stock stock) {
        observers.forEach(observer -> observer.update(stock));
    }
}
