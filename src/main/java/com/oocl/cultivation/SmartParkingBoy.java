package com.oocl.cultivation;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) throws NotEnoughPositionException {
        ParkingLot parkingLotWithMostSpaces = getParkingLotWithMostEmptyPositions();
        if (parkingLotWithMostSpaces.getAvailableSpaceNumber() != 0) {
            return parkingLotWithMostSpaces.park(car);
        }
        throw new NotEnoughPositionException();
    }

    private ParkingLot getParkingLotWithMostEmptyPositions() {
        if(super.parkingLots.size() > 1) {
            super.parkingLots.sort((parkinglot1, parkinglot2) -> parkinglot2.getAvailableSpaceNumber() - parkinglot1.getAvailableSpaceNumber());
        }
        return super.parkingLots.get(0);
    }
}
