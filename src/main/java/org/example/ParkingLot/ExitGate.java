package org.example.ParkingLot;

public class ExitGate {
    int id;
    ParkingService parkingService;
    public Ticket processExit(Ticket ticket){
      return  parkingService.exit(ticket);
    }
    ExitGate(int id, ParkingService service){
        this.id=id;
        this.parkingService=service;
    }
}
