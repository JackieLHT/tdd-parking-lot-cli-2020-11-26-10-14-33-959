package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTest {
    @Test
    public void should_throw_UnrecognizedParkingTicketException_when_fetch_given_fake_ticket() throws UnrecognizedParkingTicketException {
        ParkingLot parkinglot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkinglot);
        Ticket ticket = new Ticket();

        assertThrows(UnrecognizedParkingTicketException.class,()->{
            parkingBoy.fetch(ticket);
        },"Unrecognized parking ticket");

    }

    @Test
    public void should_throw_NotEnoughPositionException_when_park_given_a_car_and_parkinglot_is_full() throws NotEnoughPositionException {
        ParkingLot parkinglot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkinglot);
        Car car1 = new Car();
        Car car2 = new Car();

        parkinglot.park(car1);

        assertThrows(UnrecognizedParkingTicketException.class,()->{
            parkingBoy.park(car2);
        },"Not enough position.");

    }


}
