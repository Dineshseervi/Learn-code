package main.java.structural.decorator.pizzashop.addOn;

import main.java.structural.decorator.pizzashop.Pizza;

public class Cheeze extends PizzaDecorator{

    private double cost=50;
    public Cheeze(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getCost() {
        return super.getCost()+cost;
    }
}
