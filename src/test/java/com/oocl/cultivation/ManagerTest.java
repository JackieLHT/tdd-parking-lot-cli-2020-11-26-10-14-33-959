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

    @Test
    public void should_specific_parking_boy_park_the_car_when_assignPark_given_a_car_and_a_parkingboy() throws UnrecognizedParkingTicketException,NotEnoughPositionException{
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ParkingLot parkingLot3 = new ParkingLot();
        ParkingLot parkingLot4 = new ParkingLot();
        List<ParkingLot> parkingLotList1 = new ArrayList<>();
        List<ParkingLot> parkingLotList2 = new ArrayList<>();
        List<ParkingLot> parkingLotList3 = new ArrayList<>();
        List<ParkingLot> parkingLotList4 = new ArrayList<>();
        parkingLotList1.add(parkingLot1);
        parkingLotList2.add(parkingLot2);
        parkingLotList3.add(parkingLot3);
        parkingLotList4.add(parkingLot4);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList2);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotList3);
        Manager manager = new Manager(parkingLotList4);
        manager.addParkingBoyToList(standardParkingBoy);
        manager.addParkingBoyToList(smartParkingBoy);
        manager.addParkingBoyToList(superSmartParkingBoy);
        Car car = new Car();

        Ticket ticket = manager.assignPark(smartParkingBoy,car);

        assertSame(car, parkingLot2.fetch(ticket));
    }

    @Test
    public void should_specific_parking_boy_fetch_the_car_when_assignFetch_given_a_ticket_and_a_parkingboy() throws UnrecognizedParkingTicketException,NotEnoughPositionException{
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ParkingLot parkingLot3 = new ParkingLot();
        ParkingLot parkingLot4 = new ParkingLot();
        List<ParkingLot> parkingLotList1 = new ArrayList<>();
        List<ParkingLot> parkingLotList2 = new ArrayList<>();
        List<ParkingLot> parkingLotList3 = new ArrayList<>();
        List<ParkingLot> parkingLotList4 = new ArrayList<>();
        parkingLotList1.add(parkingLot1);
        parkingLotList2.add(parkingLot2);
        parkingLotList3.add(parkingLot3);
        parkingLotList4.add(parkingLot4);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList2);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotList3);
        Manager manager = new Manager(parkingLotList4);
        manager.addParkingBoyToList(standardParkingBoy);
        manager.addParkingBoyToList(smartParkingBoy);
        manager.addParkingBoyToList(superSmartParkingBoy);
        Car car = new Car();

        Ticket ticket = manager.assignPark(smartParkingBoy,car);
        Car actual = manager.assignFetch(smartParkingBoy,ticket);

        assertSame(car, actual);
    }

    @Test
    public void should_only_park_and_fetch_in_own_parkinglot_when_given_a_car_or_a_ticket() throws UnrecognizedParkingTicketException,NotEnoughPositionException{
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        List<ParkingLot> parkingLotList1 = new ArrayList<>();
        List<ParkingLot> parkingLotList2 = new ArrayList<>();
        parkingLotList1.add(parkingLot1);
        parkingLotList2.add(parkingLot2);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList1);
        Manager manager = new Manager(parkingLotList2);
        manager.addParkingBoyToList(standardParkingBoy);
        Car car = new Car();

        Ticket ticket = manager.park(car);

        assertSame(car, parkingLot2.fetch(ticket));
    }


}
