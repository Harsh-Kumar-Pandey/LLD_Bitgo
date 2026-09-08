package org.example.ParkingLot;

public class ParkingSpot {
    int id;
    SpotSize size;
    Vehicle vehicle;

    public boolean canFit(Vehicle vehicle){
        if(size==SpotSize.SMALL&&vehicle.type==VehicleType.BIKE){
            return true;
        }else if(size==SpotSize.MEDIUM&&vehicle.type==VehicleType.CAR){
            return true;
        }else if(size==SpotSize.LARGE&&vehicle.type==VehicleType.BUS){
            return true;
        }
        return false;
    }
    ParkingSpot(int id, SpotSize size){
        this.id=id;
        this.size=size;
    }
}
