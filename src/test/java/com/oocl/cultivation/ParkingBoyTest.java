package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    @Test
    void should_return_ticket_when_park_given_car() {
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        Ticket ticket = parkingBoy.park(car);

        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_park_given_ticket() throws UnrecognizedParkingTicketException {
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        Ticket ticket = parkingBoy.park(car);
        Car actual = parkingBoy.fetch(ticket);

        assertEquals(car,actual);
    }
}
