package com.oocl.cultivation;

import java.util.Collections;
import java.util.List;

public class SuperSmartParkingBoy extends StandardParkingBoy{
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) throws NotEnoughPositionException{
        ParkingLot parkingLotLargestAvailablePositionRate = getParkingLotWithLargestAvailablePositionRate();
        if (parkingLotLargestAvailablePositionRate.getAvailableSpace() != 0) {
            return parkingLotLargestAvailablePositionRate.park(car);
        }
        throw new NotEnoughPositionException();
    }

    private ParkingLot getParkingLotWithLargestAvailablePositionRate() {
        super.parkingLots.sort((parkinglot1, parkinglot2) -> Float.compare(parkinglot1.getAvailablePositionRate(),parkinglot2.getAvailablePositionRate()));
        Collections.reverse(parkingLots);
        return super.parkingLots.get(0);
    }
}
