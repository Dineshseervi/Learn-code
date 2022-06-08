package main.java.structural.observerpattern.school;

import main.java.structural.observerpattern.IObserver;
import main.java.structural.observerpattern.ISubject;

import java.util.ArrayList;
import java.util.List;

public class NotifyDepartment implements ISubject {
    private String message;

    private List<IObserver> schoolClasses = new ArrayList<>();

    @Override
    public void register(IObserver observer) {
        schoolClasses.add(observer);
    }

    @Override
    public void remove(IObserver observer) {
        schoolClasses.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (IObserver observer : schoolClasses) {
            observer.update(this);
        }
    }

    public void communicationMessage(String message) {
        this.message = message;
        notifyObserver();
    }

    public String getMessage() {
        return message;
    }
}
