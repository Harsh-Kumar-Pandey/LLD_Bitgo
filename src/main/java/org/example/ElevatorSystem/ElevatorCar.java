package org.example.ElevatorSystem;

import java.util.Collections;
import java.util.TreeSet;

public class ElevatorCar {
    int id;
    ElevatorDirection currentDirection;
    TreeSet<Integer>upRequests;
    TreeSet<Integer> downRequests;
    int currentFloor;

    public ElevatorCar(int id){
        this.id=(int)id;
        this.upRequests=new TreeSet<>();
        this.downRequests=new TreeSet<>(Collections.reverseOrder());
        this.currentFloor=0;
        currentDirection=ElevatorDirection.IDLE;
    }
    public void addDestination(int floor){

      if(floor>currentFloor){
          upRequests.add(floor);
          if(currentDirection==ElevatorDirection.IDLE){
              currentDirection=ElevatorDirection.UP;
          }

      }else{
          downRequests.add(floor);
          if(currentDirection==ElevatorDirection.IDLE){
              currentDirection=ElevatorDirection.DOWN;
          }
      }
    }
    private void openDoor(){
        System.out.println("Elevator door open: "+this.id);
    }

    public void step(){

        if(currentDirection==ElevatorDirection.UP){

            if(!upRequests.isEmpty()){
                if(currentFloor<upRequests.first()){
                    currentFloor++;
                }
                if(currentFloor==upRequests.first()){
                    upRequests.removeFirst();
                    openDoor();
                }

            }else if(!downRequests.isEmpty()){
                currentDirection=ElevatorDirection.DOWN;
            }else{
                currentDirection=ElevatorDirection.IDLE;
            }
        } else if(currentDirection==ElevatorDirection.DOWN){
            if(!downRequests.isEmpty()){
                if(currentFloor>downRequests.first()){
                    currentFloor--;
                }
                if(currentFloor==downRequests.first()){
                    downRequests.removeFirst();
                    openDoor();
                }
            }else if(!upRequests.isEmpty()){
                currentDirection=ElevatorDirection.UP;
            }else{
                currentDirection=ElevatorDirection.IDLE;
            }
        }
        System.out.println("Elevator id: "+this.id+", current floor: "+this.currentFloor+" current Direction: "+this.currentDirection);
    }
}
