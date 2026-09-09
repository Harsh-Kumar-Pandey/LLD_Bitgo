package org.example.ElevatorSystem;

import java.util.List;

public class ElevatorController {

    private final List<ElevatorCar> elevatorCars;
    private List<Request>requests;
    private final DispatchStrategy dispatchStrategy;

    public ElevatorController(List<ElevatorCar>elevatorCars,DispatchStrategy dispatchStrategy){
        this.elevatorCars=elevatorCars;
        this.dispatchStrategy=dispatchStrategy;
    }

    public void addRequest(Request request){
        ElevatorCar car=dispatchStrategy.selectElevator(elevatorCars,request);
        car.addDestination(request.source);
        if (request.destination > request.source) {
            car.upRequests.add(request.destination);
        } else {
            car.downRequests.add(request.destination);
        }
        System.out.println("Request added: " + request.toString()+ "assigned to: " + car.id);
    }

    public void step(){

        for(ElevatorCar car:elevatorCars){
            car.step();
        }
    }
}
