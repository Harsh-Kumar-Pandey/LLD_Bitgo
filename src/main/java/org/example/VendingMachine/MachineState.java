package org.example.VendingMachine;

public interface MachineState{

    public void selectProduct(VendingMachine machine, Integer code);


    public void insertMoney(VendingMachine machine, double amount);

    public void dispenseProduct(VendingMachine machine);

    public void returnChange(VendingMachine machine);

    public void cancelTransaction(VendingMachine machine);


}