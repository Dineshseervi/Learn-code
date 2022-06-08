package main.java.structural.decorator.pizzashop.addOn;

import main.java.structural.decorator.pizzashop.Pizza;

public class PannerAddOn extends PizzaDecorator{

    private double cost=70;
    public PannerAddOn(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getCost() {
        return super.getCost()+cost;
    }
}
