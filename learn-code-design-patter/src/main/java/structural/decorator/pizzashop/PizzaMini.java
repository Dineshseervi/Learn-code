package main.java.structural.decorator.pizzashop;

public class PizzaMini  implements Pizza{
    private double cost=180;

    @Override
    public double getCost()
    {
        return cost;
    }


    public void setCost(double cost) {
        this.cost = cost;
    }


}
