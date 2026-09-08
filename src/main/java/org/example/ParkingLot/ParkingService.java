package org.example.ParkingLot;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class ParkingService {
    SpotManager spotManager;
    Map<Integer, Ticket> activeTickets;

    PricingStrategy pricingStrategy;

    ParkingService(SpotManager manager,PricingStrategy pricingStrategy){
        this.spotManager=manager;
        this.pricingStrategy=pricingStrategy;
        activeTickets=new HashMap<>();
    }

    public Ticket entry(Vehicle vehicle){
        ParkingSpot spot=spotManager.getSlot(vehicle);

        if(spot==null){
            System.out.println("Parking lot is full");
            return null;
        }
        System.out.println("Successfully Parked");
        ;
        Ticket ticket=spotManager.park(spot, vehicle);
        System.out.println(ticket.toString());
        activeTickets.put(ticket.id,ticket);
        return ticket;
    }

    public Ticket exit(Ticket ticket){
        ticket.exitTime= LocalTime.now();


        double price=pricingStrategy.calculatePrice(ticket);
        Payment payment=new Payment();
        payment.processPayment(price);
        ticket.payment=payment;
        System.out.println(ticket.toString());
        activeTickets.remove(ticket.id);
        return ticket;

    }
}
