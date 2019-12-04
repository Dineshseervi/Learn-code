package main.java.creational.factorypatter;

public class FileLogger implements Logger {
    @Override
    public void log() {
        System.out.println("log in File");
    }
}
