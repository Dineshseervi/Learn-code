package main.java.creational.abstractfactory.factory;

import main.java.creational.abstractfactory.Car;
import main.java.creational.abstractfactory.CarType;
import main.java.creational.abstractfactory.Location;

public class CarFactory {

    //abstract factory provide regional differences solution for product from factory
    private CarFactory() {
    }

    public static Car buildCar(CarType carType) {
        Location location = Location.DEFAULT;
        Car car = null;
        switch (location) {
            case USA:
                car = USAFactory.buildCar(carType);
                break;
            case ASIA:
                car = AsiaFactory.buildCar(carType);
                break;
            case DEFAULT:
                car = DefaultCarFactory.buildCar(carType);
                break;
            default:
                car = DefaultCarFactory.buildCar(carType);

        }
        return car;
    }
}

// but i see a issue here this code is open for modification ,if tomorrow there  is any add of factory by company then
// class should we open for extension and closed for modification