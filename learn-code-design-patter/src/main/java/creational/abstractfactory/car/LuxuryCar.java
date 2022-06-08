package main.java.creational.abstractfactory.car;

import main.java.creational.abstractfactory.Car;
import main.java.creational.abstractfactory.CarType;
import main.java.creational.abstractfactory.Location;

public class LuxuryCar extends Car {

    @Override
    public void construct() {
        System.out.println("build LuxuryCar");
    }

    public LuxuryCar(Location location) {
        super(CarType.LUXURIOUS, location);
        construct();
    }
}
