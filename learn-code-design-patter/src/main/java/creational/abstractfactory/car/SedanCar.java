package main.java.creational.abstractfactory.car;

import main.java.creational.abstractfactory.Car;
import main.java.creational.abstractfactory.CarType;
import main.java.creational.abstractfactory.Location;

public class SedanCar extends Car {

    public SedanCar(Location location) {
        super(CarType.SEDAN, location);
        construct();
    }

    @Override
    public void construct() {
        System.out.println("build sedan car ");
    }
}
