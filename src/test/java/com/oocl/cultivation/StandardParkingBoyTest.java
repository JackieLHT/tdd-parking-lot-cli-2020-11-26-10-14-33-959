package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class StandardParkingBoyTest {
    @Test
    public void should_return_ticket_when_park_given_car() throws NotEnoughPositionException {
        ParkingLot parkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car car = new Car();

        Ticket ticket = standardParkingBoy.park(car);

        assertNotNull(ticket);
    }

    @Test
    public void should_return_car_when_fetch_given_ticket() throws UnrecognizedParkingTicketException, NotEnoughPositionException {
        ParkingLot parkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car car = new Car();

        Ticket ticket = standardParkingBoy.park(car);
        Car actual = standardParkingBoy.fetch(ticket);

        assertEquals(car, actual);
    }

    @Test
    public void should_park_car_in_first_parkinglot_when_park_given_car_and_first_and_second_parkinglot_is_not_full() throws UnrecognizedParkingTicketException, NotEnoughPositionException {
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car car = new Car();

        Ticket ticket = standardParkingBoy.park(car);

        assertSame(car, parkingLot1.fetch(ticket));
    }
}
