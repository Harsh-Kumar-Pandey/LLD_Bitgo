package org.example.VendingMachine;

public class DispenseState implements MachineState{

    @Override
    public void selectProduct(VendingMachine machine, Integer code){
        System.out.println("Product already selected");
    }

    @Override
    public void insertMoney(VendingMachine machine, double amount){
        System.out.println("Money already inserted");
    }
    @Override
    public void dispenseProduct(VendingMachine machine){
        Product product=machine.intventry.aisles.get(machine.currentSelectedCode).product;

        System.out.println("Dispensing the selected product=> "+product.toString());
        machine.currentState=machine.returnChangeState;
        machine.balance=machine.balance-product.price;
        machine.returnChange();
    }
    @Override
    public void returnChange(VendingMachine machine){
        System.out.println("First take product");
    }

    @Override
    public void cancelTransaction(VendingMachine machine){
        System.out.println("Canceling transaction as per request");
        machine.currentState= machine.IdleState;
        machine.returnChange();

    }

}
