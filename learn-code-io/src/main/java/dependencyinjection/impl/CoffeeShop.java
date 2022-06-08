package main.java.dependencyinjection.impl;

import main.java.dependencyinjection.CoffeeMachine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CoffeeShop {
    public static void main(String[] args) {

        CoffeeMachine  newCoffeeMachine=new NewCoffeeMachine();
        newCoffeeMachine.brewFilterCoffee();
        Map<Integer,Set<Integer>> test =new HashMap<>();
        Integer intergerVal=5;
        test.computeIfAbsent(intergerVal,k->new HashSet<>());
    }
}
