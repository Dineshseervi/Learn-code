package main.java.creational.abstractfactory.car;

import main.java.creational.abstractfactory.Car;
import main.java.creational.abstractfactory.CarType;
import main.java.creational.abstractfactory.Location;

public class SmallCar extends Car {

    public SmallCar(Location location)
    {
        super(CarType.SMALL,location);
        construct();
    }

    @Override
    public void construct() {
        System.out.println("Building luxury car");
    }
}
