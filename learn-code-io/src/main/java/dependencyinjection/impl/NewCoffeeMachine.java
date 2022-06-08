package main.java.dependencyinjection.impl;

import main.java.dependencyinjection.CoffeeMachine;
import main.java.dependencyinjection.EspressoMachine;

public class NewCoffeeMachine implements CoffeeMachine, EspressoMachine {
    @Override
    public void brewEspressoMachine() {
        System.out.println("brewEspressoMachine");
    }

    @Override
    public void brewFilterCoffee() {
        System.out.println("brewFilterCoffee new machine");
    }
}
