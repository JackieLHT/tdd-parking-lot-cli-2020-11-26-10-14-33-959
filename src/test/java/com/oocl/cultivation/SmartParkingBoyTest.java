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
    @Test
    public void shoud_park_car_in_parkinglot_with_most_empty_positions_when_park_given_a_car_and_multiple_parking_lots_with_empty_spaces_and_some_parkinglots_are_full() throws  NotEnoughPositionException, UnrecognizedParkingTicketException{
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(20);
        ParkingLot parkingLot3 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        parkingLot1.park(car1);
        parkingLot3.park(car2);

        Ticket ticket = smartParkingBoy.park(car3);

        assertSame(car3, parkingLot2.fetch(ticket));
    }
}
