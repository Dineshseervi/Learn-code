package main.java.classloader;

public class Car {
    public Car() {
        System.out.println("Car instance is created");
        try {
           Class classObject= Class.forName("main.java.classloader.Bike",true,ClassLoader.getSystemClassLoader());
           classObject.getInterfaces();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
