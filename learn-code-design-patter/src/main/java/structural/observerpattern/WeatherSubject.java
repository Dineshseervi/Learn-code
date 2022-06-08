package main.java.structural.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherSubject implements ISubject{

    private int temp;
    private int humidity;
    private int pressure;

    private List<IObserver> observers=new ArrayList<>();




    @Override
    public void register(IObserver observer) {
            observers.add(observer);
    }

    @Override
    public void remove(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(IObserver observer:observers)
        {
            observer.update(this);
        }
    }

    public void setValues(int temp,int humidity,int pressure)
    {
        this.temp=temp;
        this.humidity=humidity;
        this.pressure=pressure;
        notifyObserver();
    }

    public int getTemp() {
        return temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getPressure() {
        return pressure;
    }
}
