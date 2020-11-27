package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static final int CAPACITY = 10;
    private Map<Ticket,Car> ticketCarMap = new HashMap<>();

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
