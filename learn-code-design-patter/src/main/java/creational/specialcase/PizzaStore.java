package main.java.creational.specialcase;

public abstract class PizzaStore {

    /*SimplePizzaFactory factory;


    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }*/

    public void orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }

    public abstract Pizza createPizza(String type);
}
