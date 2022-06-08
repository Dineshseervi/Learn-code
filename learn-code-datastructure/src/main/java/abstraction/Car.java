package main.java.abstraction;

public class Car  extends Vehicle{
    @Override
    public void printName() {
        System.out.println("i am car");
    }

    public static void main(String[] args) {
        Vehicle vehicle=new Car();
        vehicle.printName();
    }
}
