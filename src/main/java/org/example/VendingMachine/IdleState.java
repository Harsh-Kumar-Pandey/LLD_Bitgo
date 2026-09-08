package org.example.VendingMachine;

public class IdleState implements MachineState{

    @Override
    public void selectProduct(VendingMachine machine, Integer code){

        if(!machine.intventry.isAvailable(code)){
            System.out.println("this product is not available");
            return;
        }
        machine.currentSelectedCode=code;
        Aisle aisle=machine.intventry.getAisle(code);
        System.out.println("Selected product=> "+aisle.product.toString()+ " Please insert money: " + aisle.product.price);
        machine.currentState= machine.paymentPendingState;

    }
    @Override
    public void insertMoney(VendingMachine machine, double amount){
        System.out.println("Please first select the product");
    }
    @Override
    public void dispenseProduct(VendingMachine machine){
        System.out.println("Please first select the product");
    }
    public void returnChange(VendingMachine machine){
        System.out.println("No change to return");
    }
    @Override
    public void cancelTransaction(VendingMachine machine){
        System.out.println("Nothing to cancel");
    }
}
