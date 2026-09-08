package org.example.ParkingLot;

import java.time.LocalTime;

public class Ticket {

    int id;
    ParkingSpot spot;
    Vehicle vehicle;
    LocalTime entryTime;
    LocalTime exitTime;
    Payment payment;

    public Ticket(ParkingSpot spot, Vehicle vehicle){
        this.id=(int)(Math.random()*100);
        this.spot=spot;
        this.vehicle=vehicle;
        entryTime=LocalTime.now();
    }
    public String toString() {
        if (exitTime == null) {
            return "Ticket ID: " + id + ", Entry Time: " + entryTime;
        } else {
            return "Ticket ID: " + id + ", Entry Time: " + entryTime + ", Exit Time: " + exitTime + ", Payment: " + payment.toString();
        }
    }
}
