package org.example.ElevatorSystem;

import java.util.List;

public interface DispatchStrategy {
    ElevatorCar selectElevator(List<ElevatorCar> elevatorCars, Request request);
    boolean canServe(ElevatorCar elevatorCar,Request request);
}
