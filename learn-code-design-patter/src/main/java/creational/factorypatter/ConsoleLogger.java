package main.java.creational.factorypatter;

public class ConsoleLogger implements Logger {
    @Override
    public void log() {
        System.out.println("log in console");
    }
}
