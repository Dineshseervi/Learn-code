package com.learn.system.online.vehicle.parking.model;

public class Spot {
    private Vehicle vehicle;
    private boolean isAvailable=true;
    private int number;
    private SpotType spotType;

    public Spot(int number,SpotType spotType) {
        this.number = number;
        this.spotType = spotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;

        this.isAvailable=false;
    }

    public void removeVehicle()
    {
        this.vehicle=null;
        this.isAvailable=true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    /*public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }*/
}
