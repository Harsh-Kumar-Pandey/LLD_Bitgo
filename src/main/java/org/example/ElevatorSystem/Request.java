package org.example.ElevatorSystem;

public class Request {
    int id;
    int source;
    int destination;
    ElevatorDirection direction;

    public  Request(int source, int destination){
        this.id=(int)(Math.random()*1000);
        this.source=source;
        this.destination=destination;


        if(this.destination>this.source){
            this.direction=ElevatorDirection.UP;
        }else{
            this.direction=ElevatorDirection.DOWN;
        }
    }

    public String toString(){
        return "Request{id=" + id + ", source=" + source + ", destination=" + destination + ", direction=" + direction + "}";
    }
}
