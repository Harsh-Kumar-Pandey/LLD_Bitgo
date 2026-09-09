package org.example.ElevatorSystem;

import java.util.List;

public class NearestFloorStrategy implements DispatchStrategy{

    public ElevatorCar selectElevator(List<ElevatorCar> elevatorCars, Request request){

        ElevatorCar car=null;
        int minDis=Integer.MAX_VALUE;

        for(ElevatorCar e:elevatorCars){

            int dis=Math.abs(e.currentFloor- request.source);

            if(canServe(e,request)&&dis<minDis){
                minDis=dis;
                car=e;
            }
        }
        if(car==null) return elevatorCars.get(0);
        return car;
    }

    public boolean canServe(ElevatorCar elevatorCar,Request request){

        if(elevatorCar.currentDirection==ElevatorDirection.IDLE){
            return  true;
        }
        if(elevatorCar.currentDirection==ElevatorDirection.UP && request.direction==ElevatorDirection.UP && request.source >= elevatorCar.currentFloor){
            return true;
        }
        if(elevatorCar.currentDirection==ElevatorDirection.DOWN && request.direction==ElevatorDirection.DOWN && request.source <= elevatorCar.currentFloor){
            return true;
        }
        return false;
    }
}
