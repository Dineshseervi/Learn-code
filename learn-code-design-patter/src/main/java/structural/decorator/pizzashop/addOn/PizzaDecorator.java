package main.java.structural.decorator.pizzashop.addOn;

import main.java.structural.decorator.pizzashop.Pizza;

public class PizzaDecorator  implements Pizza {


    private Pizza pizza;

    public PizzaDecorator(Pizza pizza)
    {
        this.pizza=pizza;
    }
    @Override
    public double getCost() {
        return  this.pizza.getCost();
    }


}
