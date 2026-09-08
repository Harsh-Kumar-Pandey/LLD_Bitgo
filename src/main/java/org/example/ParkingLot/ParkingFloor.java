package org.example.ParkingLot;

import java.util.List;

public class ParkingFloor {
    int floor;
    List<ParkingSpot> parkingSpots;

    public ParkingSpot getSpot(Vehicle vehicle){


        for(ParkingSpot s:parkingSpots){
            if(s.vehicle==null&&s.canFit(vehicle)){
                return s;
            }
        }
        return null;
    }

    ParkingFloor(int floor,List<ParkingSpot>parkingSpots){
        this.floor=floor;
        this.parkingSpots=parkingSpots;
    }
}
