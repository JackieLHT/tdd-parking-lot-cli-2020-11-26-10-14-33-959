package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class Manager extends StandardParkingBoy{
    private List<ParkingBoy> managementList = new ArrayList<>();
    public Manager(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket assignPark(ParkingBoy parkingBoy, Car car) throws NotEnoughPositionException {
        if(managementList.contains(parkingBoy)) {
            return parkingBoy.park(car);
        }
        return null;
    }

    public void addParkingBoyToList(ParkingBoy parkingBoy) {
        managementList.add(parkingBoy);
    }

    public Car assignFetch(ParkingBoy parkingBoy, Ticket ticket) throws UnrecognizedParkingTicketException {
        if(managementList.contains(parkingBoy)) {
            return parkingBoy.fetch(ticket);
        }
        return null;
    }
}
