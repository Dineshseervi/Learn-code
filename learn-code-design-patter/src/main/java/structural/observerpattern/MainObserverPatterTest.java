package main.java.structural.observerpattern;

public class MainObserverPatterTest {

    public static void main(String[] args) {
        WeatherSubject weatherSubject=new WeatherSubject();
        //weatherSubject.setValues(30,10,5);

        IndiaTemperatureObserver indiaTemperatureObserver=new IndiaTemperatureObserver(weatherSubject);
        NewZelandTemperatureObserver newZelandTemperatureObserver=new NewZelandTemperatureObserver(weatherSubject);
        RussiaTemperatureObserver russiaTemperatureObserver=new RussiaTemperatureObserver(weatherSubject);


        weatherSubject.setValues(30,10,5);
        System.out.println("value updated \n \n");
        weatherSubject.setValues(40,12,7);

    }
}
