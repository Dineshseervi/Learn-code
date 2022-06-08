package main.java.creational.specialcase.pizzafactory;

import main.java.creational.specialcase.Pizza;
import main.java.creational.specialcase.PizzaStore;

public class ChicizoPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza=null;
        if (type.equals("cheese"))
        {
            pizza=null;//some pizza
        }
        else if(type.equals("veg"))
        {
            pizza=null;//some pizza
        }
        else {
            pizza=null;//some pizza
        }
        return pizza;
    }
}
