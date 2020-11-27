package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {


    @Test
    public void should_car_be_parked_when_park_given_car_and_parking_lot_is_not_full() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        Ticket ticket = parkingLot.park(car);

        assertNotNull(ticket);
    }
}
