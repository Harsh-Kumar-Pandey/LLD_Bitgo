package org.example.ParkingLot;

public class EnteranceGate {
    int id;
    ParkingService parkingService;

    public Ticket generateTicket(Vehicle vehicle){
         return parkingService.entry(vehicle);
    }

    EnteranceGate(int id, ParkingService service){
        this.id=id;
        this.parkingService=service;
    }
}
