package main.java.structural.observerpattern;

public class NewZelandTemperatureObserver implements IObserver {

    private int temp;
    private int humidity;
    private int pressure;

    public NewZelandTemperatureObserver(ISubject subject) {
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
        System.out.println("NewZeland Temprature Temp="+(temp +3 )+" ; humidity ="+(humidity+5)+" ; pressure="+(pressure+5));
    }
}
