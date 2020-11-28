package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity = 10;
    private Map<Ticket, Car> ticketCarMap = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        if (ticketCarMap.size() < capacity) {
            Ticket newTicket = new Ticket();
            ticketCarMap.put(newTicket, car);
            return newTicket;
        } else {
            throw new NotEnoughPositionException();
        }
    }

    public Car fetch(Ticket ticket) throws UnrecognizedParkingTicketException {

        Car car = ticketCarMap.get(ticket);
        if (car != null) {
            ticketCarMap.remove(ticket);
            return car;
        } else {
            throw new UnrecognizedParkingTicketException();
        }
    }

    public int getAvailableSpace() {
        return capacity - ticketCarMap.size();
    }

    public boolean isContainCar(Ticket ticket) {
        return ticketCarMap.containsKey(ticket);
    }
}
