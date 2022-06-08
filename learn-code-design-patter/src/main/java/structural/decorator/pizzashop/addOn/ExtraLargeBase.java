package main.java.structural.decorator.pizzashop.addOn;

import main.java.structural.decorator.pizzashop.Pizza;

public class ExtraLargeBase extends PizzaDecorator{

    private double cost=100;
    public ExtraLargeBase(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getCost() {
        return super.getCost()+cost;
    }
}
