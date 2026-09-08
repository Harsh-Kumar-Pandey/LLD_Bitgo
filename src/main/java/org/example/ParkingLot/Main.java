package org.example.ParkingLot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<ParkingFloor> parkingFloors = new ArrayList<>();
        for(int i=0;i<10;i++){
            ParkingSpot spot1=new ParkingSpot(1,SpotSize.LARGE);
            ParkingSpot spot2=new ParkingSpot(2,SpotSize.MEDIUM);
            ParkingSpot spot3=new ParkingSpot(3,SpotSize.SMALL);
            ParkingFloor parkingFloor=new ParkingFloor(i,Arrays.asList(spot1,spot2,spot3));
            parkingFloors.add(parkingFloor);
        }
        SpotManager manager=new SpotManager(parkingFloors);
        PricingStrategy strategy=new FlatPricing();
        ParkingService service=new ParkingService(manager,strategy);
        Vehicle v=new Vehicle("CG 07 CK 4429",VehicleType.CAR);
        EnteranceGate gate1=new EnteranceGate(1, service);
        ExitGate gate2=new ExitGate(2, service);

        Ticket ticket=gate1.generateTicket(v);
        gate2.processExit(ticket);



    }
}
