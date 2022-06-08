package main.java.structural.observerpattern;

public class IndiaTemperatureObserver implements IObserver {

    private int temp;
    private int humidity;
    private int pressure;

    public IndiaTemperatureObserver(ISubject subject) {
        subject.register(this);
    }

    @Override
    public void update(ISubject subject) {
        if (subject instanceof WeatherSubject) {
            temp=((WeatherSubject) subject).getTemp();
            humidity=((WeatherSubject) subject).getHumidity();
            pressure=((WeatherSubject) subject).getPressure();
        }
        display();
    }

    @Override
    public void display() {
        System.out.println("INDIA Temprature Temp="+temp+" ; humidity ="+humidity+" ; pressure="+pressure);
    }
}
