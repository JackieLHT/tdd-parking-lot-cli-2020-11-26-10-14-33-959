package com.oocl.cultivation;

import java.util.List;

public class StandardParkingBoy extends ParkingBoy{

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        for(ParkingLot parkinglot: parkingLots) {
            if(parkinglot.getAvailableSpace() > 0) {
               return parkinglot.park(car);
            }
        }
        throw new NotEnoughPositionException();
    }
}
