package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

public class ParkingLotTest {

    @Test
    public void should_return_ticket_when_park_given_car_and_parking_lot_is_not_full() {
        ParkingLot parkingLot = new ParkingLot(5);
        Car car = new Car();

        Ticket ticket = parkingLot.park(car);

        assertNotNull(ticket);
    }

    @Test
    public void should_not_return_ticket_when_park_given_car_and_parking_lot_is_full() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car1 = new Car();
        Car car2 = new Car();

        parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);

        assertNull(ticket2);
    }

    @Test
    public void should_return_car_when_fetch_given_correct_ticket_and_car_in_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(5);
        Car car = new Car();

        parkingLot.park(car);
        Ticket ticket = parkingLot.park(car);

        Car actual = parkingLot.fetch(ticket);

        assertEquals(car,actual);
    }

    @Test
    public void should_return_car_when_fetch_given_fake_ticket() {
        ParkingLot parkingLot = new ParkingLot(5);
        Ticket ticket = new Ticket();

        Car actual = parkingLot.fetch(ticket);

        assertNull(actual);
    }


}
