package main.java.creational.abstractfactory.factory;

import main.java.creational.abstractfactory.Car;
import main.java.creational.abstractfactory.CarType;
import main.java.creational.abstractfactory.Location;
import main.java.creational.abstractfactory.car.LuxuryCar;
import main.java.creational.abstractfactory.car.SedanCar;
import main.java.creational.abstractfactory.car.SmallCar;

public class AsiaFactory {


    public static Car buildCar(CarType model)
    {
        Car car = null;
        switch (model)
        {
            case SMALL:
                car = new SmallCar(Location.ASIA);
                break;

            case SEDAN:
                car = new SedanCar(Location.ASIA);
                break;

            case LUXURIOUS:
                car = new LuxuryCar(Location.ASIA);
                break;

            default:
                //throw some exception
                break;
        }
        return car;
    }
}
