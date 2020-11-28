package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class Manager extends StandardParkingBoy{
    private List<ParkingBoy> managementList = new ArrayList<>();
    public Manager(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket assignPark(ParkingBoy parkingBoy, Car car) throws NotEnoughPositionException {
        return parkingBoy.park(car);
    }


}
