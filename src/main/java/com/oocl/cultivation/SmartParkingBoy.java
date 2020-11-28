package com.oocl.cultivation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends StandardParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) throws NotEnoughPositionException {
        ParkingLot parkingLotWithMostSpaces = getParkingLotWithMostEmptyPositions();
        if (parkingLotWithMostSpaces.getAvailableSpace() != 0) {
            return parkingLotWithMostSpaces.park(car);
        }
        throw new NotEnoughPositionException();
    }

    private ParkingLot getParkingLotWithMostEmptyPositions() {
        super.parkingLots.sort((parkinglot1, parkinglot2) -> parkinglot2.getAvailableSpace() - parkinglot1.getAvailableSpace());
        return super.parkingLots.get(0);
    }
}
