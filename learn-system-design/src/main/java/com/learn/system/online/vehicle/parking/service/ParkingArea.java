package com.learn.system.online.vehicle.parking.service;

import com.learn.system.online.vehicle.parking.model.ParkingLot;
import com.learn.system.online.vehicle.parking.model.Spot;
import com.learn.system.online.vehicle.parking.model.SpotType;
import com.learn.system.online.vehicle.parking.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=tVRyb4HaHgw&t=12s&ab_channel=ThinkSoftware
public class ParkingArea {

    private List<ParkingLot> parkingLots;

    public ParkingArea() {
        initParkingArea(5);
    }

    private void initParkingArea(int level)
    {
        parkingLots=new ArrayList<>();
        for(int i=1;i<=level;i++)
        {
           parkingLots.add(new ParkingLot(i));
        }
    }

    private void addSlots()
    {
        for(ParkingLot parkingLot:parkingLots)
        {
            for (int i=1;i<50;i++) {
                if(i<10) {
                    parkingLot.addSpot(new Spot(i, SpotType.LARGE));
                }else if(i>10 && i<30)
                {
                    parkingLot.addSpot(new Spot(i, SpotType.MEDIUM));
                }else {
                    parkingLot.addSpot(new Spot(i, SpotType.SMALL));
                }
            }
        }
    }



    public boolean addVehicle(Vehicle vehicle)
    {
        for(ParkingLot parkingLot:parkingLots)
        {
            for(Spot spot:parkingLot.getSpots())
            {
                if(spot.isAvailable())
                {
                    if(spot.getSpotType()==vehicle.getVehicleType().getSpotType())
                    {
                        spot.addVehicle(vehicle);
                        System.out.println("spot id : "+spot.getNumber());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void checkOut(Vehicle vehicle)
    {
        for(ParkingLot parkingLot:parkingLots)
        {
            for(Spot spot:parkingLot.getSpots())
            {
                if(!spot.isAvailable())
                {
                    if(spot.getVehicle().getNumberPlate().equals(vehicle.getNumberPlate()))
                    {
                        spot.removeVehicle();
                        return;
                    }
                }
            }
        }
    }
}

