package org.example.ParkingLot;

import java.util.List;

public class SpotManager {
    List<ParkingFloor> parkingFloors;

    public ParkingSpot getSlot(Vehicle vehicle){

        for(ParkingFloor floor:parkingFloors){
            ParkingSpot s= floor.getSpot(vehicle);
            if(s!=null){
                return s;
            }
        }
        return null;
    }
    public Ticket park(ParkingSpot spot, Vehicle vehicle){
        spot.vehicle=vehicle;
        return new Ticket(spot, vehicle);
    }
    SpotManager(List<ParkingFloor> parkingFloors){
        this.parkingFloors=parkingFloors;
    }
}
