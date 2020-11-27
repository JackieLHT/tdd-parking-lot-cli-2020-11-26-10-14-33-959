package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity = 10;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    private Map<Ticket,Car> ticketCarMap = new HashMap<>();

    public Ticket park(Car car) {
        if(ticketCarMap.size() < capacity)
        {
            Ticket newTicket = new Ticket();
            ticketCarMap.put(newTicket,car);
            return newTicket;
        }
        return null;
    }

    public Car fetch(Ticket ticket) {
        if(ticketCarMap.containsKey(ticket)) {
            Car car =  ticketCarMap.get(ticket);
            ticketCarMap.remove(ticket);
            return car;
        }
        return null;
    }
}
