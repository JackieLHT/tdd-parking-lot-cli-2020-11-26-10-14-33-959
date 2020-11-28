package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;

public class SmartParkingBoyTest {
    @Test
    public void shoud_park_car_in_parkinglot_with_most_empty_positions_when_park_given_a_car_and_multiple_parking_lots_with_empty_spaces() throws  NotEnoughPositionException, UnrecognizedParkingTicketException{
        ParkingLot parkingLot1 = new ParkingLot(5);
        ParkingLot parkingLot2 = new ParkingLot(10);
        ParkingLot parkingLot3 = new ParkingLot(20);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();

        Ticket ticket = smartParkingBoy.park(car);

        assertSame(car, parkingLot3.fetch(ticket));
    }
}
