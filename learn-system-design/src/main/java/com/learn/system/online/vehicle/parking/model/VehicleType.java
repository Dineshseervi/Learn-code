package com.learn.system.online.vehicle.parking.model;

public enum VehicleType {
    CYCLE(SpotType.SMALL),MOTOR_CYCLE(SpotType.SMALL),CAR(SpotType.MEDIUM),BIG_VEHICLE(SpotType.LARGE);

    private SpotType spotType;
    VehicleType(SpotType spotType) {
        this.spotType=spotType;
    }

    public SpotType getSpotType() {
        return spotType;
    }
}
