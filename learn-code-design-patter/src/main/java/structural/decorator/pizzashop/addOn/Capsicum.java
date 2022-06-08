package main.java.structural.decorator.pizzashop.addOn;

import main.java.structural.decorator.pizzashop.Pizza;

public class Capsicum extends PizzaDecorator{

    private double cost=30;
    public Capsicum(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getCost() {
        return super.getCost()+cost;
    }
}
