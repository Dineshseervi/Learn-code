package main.java.creational.specialcase;

public class SimplePizzaFactory {

    public Pizza createPizza(String type)
    {
        Pizza pizza=null;
        if(type.equals("cheese"))
        {
            pizza=null;
        }
        else if(type.equals("pepperoni"))
        {
            pizza=null;
        }
        return  pizza;

    }
}
