package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int CAPACITY;
    private Map<Ticket,Car> ticketCarMap = new HashMap<>();

    public ParkingLot(int capacity) {
        this.CAPACITY = capacity;
    }

    public Ticket park(Car car) {
        if(ticketCarMap.size() < CAPACITY)
        {
            Ticket newTicket = new Ticket();
            ticketCarMap.put(newTicket,car);
            return newTicket;
        }
        return null;
    }
}
