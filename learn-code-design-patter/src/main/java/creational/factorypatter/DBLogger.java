package main.java.creational.factorypatter;


public class DBLogger implements Logger {
    @Override
    public void log() {
   // get connection
        System.out.println("log in db");
    }
}
