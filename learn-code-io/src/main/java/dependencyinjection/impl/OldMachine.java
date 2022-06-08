package main.java.dependencyinjection.impl;

import main.java.dependencyinjection.CoffeeMachine;

public class OldMachine implements CoffeeMachine {
    @Override
    public void brewFilterCoffee() {
        System.out.println("brewFilterCoffee");
    }
}
