package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;

public class SuperSmartParkingBoyTest {
    @Test
    public void shoud_park_car_in_parkinglot_with_larger_available_position_rate_when_park_given_a_car_and_multiple_parking_lots_with_empty_spaces() throws  NotEnoughPositionException, UnrecognizedParkingTicketException{
        ParkingLot parkingLot1 = new ParkingLot(3);
        ParkingLot parkingLot2 = new ParkingLot(2);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        parkingLot1.park(car1);
        parkingLot1.park(car2);
        parkingLot2.park(car3);

        Ticket ticket = superSmartParkingBoy.park(car4);

        assertSame(car4, parkingLot2.fetch(ticket));
    }

    @Test
    public void shoud_park_car_in_parkinglot_with_most_empty_positions_when_park_given_a_car_and_multiple_parking_lots_with_empty_spaces_and_some_parkinglots_are_full() throws  NotEnoughPositionException, UnrecognizedParkingTicketException{
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(3);
        ParkingLot parkingLot3 = new ParkingLot(2);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        parkingLot1.park(car1);
        parkingLot2.park(car2);


        Ticket ticket = superSmartParkingBoy.park(car3);

        assertSame(car3, parkingLot3.fetch(ticket));
    }
}
