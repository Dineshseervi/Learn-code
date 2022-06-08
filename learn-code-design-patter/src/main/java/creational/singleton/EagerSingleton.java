package main.java.creational.singleton;

public class EagerSingleton {

    private static EagerSingleton eagerSingleton=new EagerSingleton();

    private EagerSingleton()
    {}

    public static EagerSingleton getInstance()
    {
        return eagerSingleton;
    }

}
