package com.oocl.cultivation;

import java.util.List;

public abstract class ParkingBoy {
    protected List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public abstract Ticket park(Car car) throws NotEnoughPositionException;

    public Car fetch(Ticket ticket) throws UnrecognizedParkingTicketException {
        for(ParkingLot parkinglot:parkingLots) {
            if(parkinglot.isContainCar(ticket))
            {
                return parkinglot.fetch(ticket);
            }
        }
        throw new UnrecognizedParkingTicketException();
    }
}
