package main.java.structural.decorator.pizzashop.counter;

import main.java.structural.decorator.pizzashop.Pizza;
import main.java.structural.decorator.pizzashop.PizzaMini;
import main.java.structural.decorator.pizzashop.addOn.Capsicum;
import main.java.structural.decorator.pizzashop.addOn.Cheeze;
import main.java.structural.decorator.pizzashop.addOn.ExtraLargeBase;
import main.java.structural.decorator.pizzashop.addOn.Mashrom;

public class PizzaCounter  {

    public static void main(String[] args) {
        Pizza pizza=new PizzaMini();
        pizza=addOnPizza(pizza);
        System.out.println("pizza total cost "+pizza.getCost());
    }

    private static Pizza addOnPizza(Pizza pizza) {
        return  new Capsicum(new Cheeze(new Mashrom( new ExtraLargeBase(pizza))));
    }
}
