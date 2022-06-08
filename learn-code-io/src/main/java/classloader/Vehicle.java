package main.java.classloader;

public class Vehicle {
    public Vehicle() {
        System.out.println("vehicle instance");

    }

    public static void main(String[] args) {
        Car car=new Car();
    }
}
