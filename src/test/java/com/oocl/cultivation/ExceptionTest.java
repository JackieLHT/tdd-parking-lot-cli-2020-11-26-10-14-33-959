package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTest {
    @Test
    public void should_throw_Unrecognized_parking_ticket_exception_when_park_given_fake_ticket() throws UnrecognizedParkingTicket{
        ParkingLot parkinglot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkinglot);
        Ticket ticket = new Ticket();

        assertThrows(UnrecognizedParkingTicket.class,()->{
            parkingBoy.fetch(ticket);
        },"Unrecognized parking ticket");

    }
}
