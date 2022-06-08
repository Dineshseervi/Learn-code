package main.java.structural.observerpattern.inbuilt;

import java.util.Observable;

public class WeatherForcastSubject extends Observable {
    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(arg);
    }

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }
}
