package com.learn.system.online.vehicle.parking.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Spot> spots;
    private int level;

    public ParkingLot(int level) {
        this.level = level;
        this.spots=new ArrayList<>();
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public void addSpot(Spot spot)
    {
        this.spots.add(spot);
    }
}
