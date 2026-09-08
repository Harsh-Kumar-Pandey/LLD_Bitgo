package org.example.VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class Intventry {

    Map<Integer,Aisle>aisles;

    Intventry()
    {
        aisles=new HashMap<>();
    }
    public void addAisle(Aisle aisle){

        aisles.put(aisle.code,aisle);
    }

    public Aisle getAisle(int code){
       return aisles.get(code);
    }

    public boolean isAvailable(int code){

        if(aisles.get(code)==null||aisles.get(code).quantity<=0) return false;
        return true;
    }

}
