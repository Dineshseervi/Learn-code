package main.java.creational.abstractfactory;

public abstract class Car {

    private CarType carType;
    private Location location;

    public Car(CarType carType, Location location) {
        this.carType = carType;
        this.location = location;
    }

    public abstract void construct();

    @Override
    public String toString() {
        return "Car{" +
                "carType=" + carType +
                ", location=" + location +
                '}';
    }
}
