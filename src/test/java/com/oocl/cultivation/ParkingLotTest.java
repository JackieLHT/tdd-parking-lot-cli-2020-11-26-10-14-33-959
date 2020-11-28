package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
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
    public void should_return_only_1_ticket_when_park_given_mutiple_cars_and_parking_lot_has_1_space() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car1 = new Car();
        Car car2 = new Car();

        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);

        assertNotNull(ticket1);
        assertNull(ticket2);
    }

    @Test
    public void should_park_all_cars_when_park_given_mutiple_cars_and_parking_lot_has_enough_spaces() {
        ParkingLot parkingLot = new ParkingLot(5);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();

        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);
        Ticket ticket3 = parkingLot.park(car3);
        Ticket ticket4 = parkingLot.park(car4);

        assertNotNull(ticket1);
        assertNotNull(ticket2);
        assertNotNull(ticket3);
        assertNotNull(ticket4);
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
    public void should_return_null_when_fetch_given_fake_ticket() {
        ParkingLot parkingLot = new ParkingLot(5);
        Ticket ticket = new Ticket();

        Car actual = parkingLot.fetch(ticket);

        assertNull(actual);
    }

    @Test
    public void should_return_null_when_fetch_given_used_ticket() {
        ParkingLot parkingLot = new ParkingLot(5);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        parkingLot.fetch(ticket);

        Car actual = parkingLot.fetch(ticket);

        assertNull(actual);
    }


}
