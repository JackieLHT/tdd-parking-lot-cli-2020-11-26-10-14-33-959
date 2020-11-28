package com.oocl.cultivation;

import java.util.List;

public class StandardParkingBoy {
    private List<ParkingLot> parkingLots;

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        for(ParkingLot parkinglot: parkingLots) {
            if(parkinglot.getAvailableSpace() > 0) {
               return parkinglot.park(car);
            }
        }
        throw new NotEnoughPositionException();
    }

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
