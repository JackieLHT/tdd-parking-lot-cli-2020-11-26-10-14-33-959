package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class StandardParkingBoyTest {
    @Test
    public void should_return_ticket_when_park_given_car() throws NotEnoughPositionException {
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();

        Ticket ticket = standardParkingBoy.park(car);

        assertNotNull(ticket);
    }

    @Test
    public void should_return_car_when_park_given_ticket() throws UnrecognizedParkingTicketException, NotEnoughPositionException {
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();

        Ticket ticket = standardParkingBoy.park(car);
        Car actual = standardParkingBoy.fetch(ticket);

        assertEquals(car, actual);
    }

}
