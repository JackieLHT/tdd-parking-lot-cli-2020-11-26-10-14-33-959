package com.oocl.cultivation;

import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;

public class ManagerTest {
    @Test
    public void should_park_and_fetch_the_car_in_first_parking_lot_when_park_given_a_car_and_multiple_parkinglots_with_spaces() throws NotEnoughPositionException,UnrecognizedParkingTicketException{
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        Manager manager = new Manager(parkingLots);
        Car car = new Car();

        Ticket ticket = manager.park(car);

        assertSame(car, parkingLot1.fetch(ticket));
    }


}
