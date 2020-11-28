package com.oocl.cultivation;

import java.util.List;

public class StandardParkingBoy {
    private List<ParkingLot> parkingLot;

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        return parkingLot.park(car);
    }

    public Car fetch(Ticket ticket) throws UnrecognizedParkingTicketException {
        return parkingLot.fetch(ticket);
    }
}
