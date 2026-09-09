package org.example.ElevatorSystem;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ElevatorCar car1=new ElevatorCar(1);
        ElevatorCar car2=new ElevatorCar(2);

        Request r1=new Request(3,7);
        Request r2=new Request(5,1);
        Request r3=new Request(0,10);

        List<ElevatorCar> elevators = Arrays.asList(car1, car2);

        ElevatorController controller=new ElevatorController(elevators,new NearestFloorStrategy());

        controller.addRequest(r1);
        controller.addRequest(r2);
        controller.addRequest(r3);

        for(int i=0;i<20;i++){
            System.out.println("Time: "+ i);
            controller.step();
        }

    }
}
