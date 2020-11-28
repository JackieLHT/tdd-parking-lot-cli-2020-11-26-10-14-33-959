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
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Ticket ticket = new Ticket();

        assertThrows(UnrecognizedParkingTicketException.class, () -> {
            parkinglot.fetch(ticket);
        }, "Unrecognized parking ticket.");

        assertThrows(UnrecognizedParkingTicketException.class, () -> {
            standardParkingBoy.fetch(ticket);
        }, "Unrecognized parking ticket.");

        assertThrows(UnrecognizedParkingTicketException.class, () -> {
            smartParkingBoy.fetch(ticket);
        }, "Unrecognized parking ticket.");


        assertThrows(UnrecognizedParkingTicketException.class, () -> {
            superSmartParkingBoy.fetch(ticket);
        }, "Unrecognized parking ticket.");


    }

    @Test
    public void should_throw_UnrecognizedParkingTicketException_when_fetch_given_used_ticket() throws UnrecognizedParkingTicketException,NotEnoughPositionException {
        ParkingLot parkinglot = new ParkingLot(10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkinglot);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Manager manager = new Manager(parkingLots);
        Car car = new Car();

        Ticket ticket = standardParkingBoy.park(car);
        standardParkingBoy.fetch(ticket);

        assertThrows(UnrecognizedParkingTicketException.class, () -> {
            parkinglot.fetch(ticket);
        }, "Unrecognized parking ticket.");

        assertThrows(UnrecognizedParkingTicketException.class, () -> {
            standardParkingBoy.fetch(ticket);
        }, "Unrecognized parking ticket.");

        assertThrows(UnrecognizedParkingTicketException.class, () -> {
            smartParkingBoy.fetch(ticket);
        }, "Unrecognized parking ticket.");


        assertThrows(UnrecognizedParkingTicketException.class, () -> {
            superSmartParkingBoy.fetch(ticket);
        }, "Unrecognized parking ticket.");

        assertThrows(UnrecognizedParkingTicketException.class, () -> {
            manager.fetch(ticket);
        }, "Unrecognized parking ticket.");

    }

    @Test
    public void should_throw_NotEnoughPositionException_when_park_given_a_car_and_all_parkinglots_are_full() throws NotEnoughPositionException {
        ParkingLot parkinglot1 = new ParkingLot(1);
        ParkingLot parkinglot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkinglot1);
        parkingLots.add(parkinglot1);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Manager manager = new Manager(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        parkinglot1.park(car1);
        parkinglot2.park(car2);

        assertThrows(NotEnoughPositionException.class, () -> {
            parkinglot1.park(car3);
        }, "Not enough position.");

        assertThrows(NotEnoughPositionException.class, () -> {
            standardParkingBoy.park(car3);
        }, "Not enough position.");

        assertThrows(NotEnoughPositionException.class, () -> {
            smartParkingBoy.park(car3);
        }, "Not enough position.");

        assertThrows(NotEnoughPositionException.class, () -> {
            superSmartParkingBoy.park(car3);
        }, "Not enough position.");

        assertThrows(NotEnoughPositionException.class, () -> {
            manager.park(car3);
        }, "Not enough position.");

    }

    @Test
    public void should_throw_NotEnoughPositionException_when_assignPark_given_a_car_and_a_specific_parkingboy_and_all_parkinglots_are_full() throws NotEnoughPositionException {
        ParkingLot parkinglot1 = new ParkingLot(1);
        ParkingLot parkinglot2 = new ParkingLot(1);
        List<ParkingLot> parkingLotList1 = new ArrayList<>();
        List<ParkingLot> parkingLotList2 = new ArrayList<>();
        parkingLotList1.add(parkinglot1);
        parkingLotList2.add(parkinglot2);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList1);
        Manager manager = new Manager(parkingLotList2);
        Car car1 = new Car();
        Car car2 = new Car();

        parkinglot1.park(car1);

        assertThrows(NotEnoughPositionException.class, () -> {
            manager.assignPark(standardParkingBoy,car2)
        }, "Not enough position.");

    }

    @Test
    public void should_throw_UnrecognizedParkingTicketException_when_assignFetch_given_a_fake_or_used_tcket_and_a_specific_parkingboy() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        ParkingLot parkinglot1 = new ParkingLot(1);
        ParkingLot parkinglot2 = new ParkingLot(1);
        List<ParkingLot> parkingLotList1 = new ArrayList<>();
        List<ParkingLot> parkingLotList2 = new ArrayList<>();
        parkingLotList1.add(parkinglot1);
        parkingLotList2.add(parkinglot2);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList1);
        Manager manager = new Manager(parkingLotList2);
        Car car1 = new Car();
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = parkinglot1.park(car1);

        assertThrows(NotEnoughPositionException.class, () -> {
            manager.assignFetch(standardParkingBoy,ticket1)
        }, "Unrecognized parking ticket.");

        assertThrows(NotEnoughPositionException.class, () -> {
            manager.assignFetch(standardParkingBoy,ticket2);
        }, "Unrecognized parking ticket.");

    }


}
