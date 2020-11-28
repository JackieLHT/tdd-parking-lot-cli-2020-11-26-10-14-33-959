package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTest {
    @Test
    public void should_throw_UnrecognizedParkingTicketException_when_fetch_given_fake_ticket() throws UnrecognizedParkingTicketException {
        ParkingLot parkinglot = new ParkingLot(10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkinglot);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Ticket ticket = new Ticket();

        assertThrows(UnrecognizedParkingTicketException.class, () -> {
            parkinglot.fetch(ticket);
        }, "Unrecognized parking ticket.");

        assertThrows(UnrecognizedParkingTicketException.class, () -> {
            standardParkingBoy.fetch(ticket);
        }, "Unrecognized parking ticket.");

    }

    @Test
    public void should_throw_UnrecognizedParkingTicketException_when_fetch_given_used_ticket() throws UnrecognizedParkingTicketException,NotEnoughPositionException {
        ParkingLot parkinglot = new ParkingLot(10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkinglot);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car car = new Car();

        Ticket ticket = standardParkingBoy.park(car);
        standardParkingBoy.fetch(ticket);

        assertThrows(UnrecognizedParkingTicketException.class, () -> {
            parkinglot.fetch(ticket);
        }, "Unrecognized parking ticket.");

        assertThrows(UnrecognizedParkingTicketException.class, () -> {
            standardParkingBoy.fetch(ticket);
        }, "Unrecognized parking ticket.");

    }

    @Test
    public void should_throw_NotEnoughPositionException_when_park_given_a_car_and_parkinglot_is_full() throws NotEnoughPositionException {
        ParkingLot parkinglot = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkinglot);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();

        parkinglot.park(car1);

        assertThrows(NotEnoughPositionException.class, () -> {
            parkinglot.park(car2);
        }, "Not enough position.");

        assertThrows(NotEnoughPositionException.class, () -> {
            standardParkingBoy.park(car2);
        }, "Not enough position.");

    }


}
