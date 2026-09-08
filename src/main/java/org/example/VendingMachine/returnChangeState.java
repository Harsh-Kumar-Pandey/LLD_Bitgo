package org.example.VendingMachine;

public class returnChangeState implements MachineState{

    public void selectProduct(VendingMachine machine, Integer code){
        System.out.println("Returning change, please select again");
    }


    public void insertMoney(VendingMachine machine, double amount){
        System.out.println("Returning change, please select again");
    }

    public void dispenseProduct(VendingMachine machine){
        System.out.println("Returning change, please select again");
    }

    public void returnChange(VendingMachine machine){
        System.out.println("Returning change");
        double remainingMoney= machine.balance-machine.intventry.aisles.get(machine.currentSelectedCode).product.price;
        machine.returnChange(remainingMoney);
        machine.currentState=machine.IdleState;
    }

    public void cancelTransaction(VendingMachine machine){
        System.out.println("Transaction cancelled, returning change");
        machine.returnChange();
        machine.currentState= machine.IdleState;
    }
}
