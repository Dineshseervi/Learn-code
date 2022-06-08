package com.learn.system.online.vehicle.parking.model;

import java.util.Date;
public interface Vehicle {

    public String getNumberPlate();
    public Date getParkingTime();
    public VehicleType getVehicleType();
}
