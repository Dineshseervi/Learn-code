package main.java.structural.observerpattern;

public interface ISubject
{
    public void register(IObserver observer);
    public void remove(IObserver observer);
    public void notifyObserver();
}
