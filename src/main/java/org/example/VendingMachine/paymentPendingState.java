package org.example.VendingMachine;

public class paymentPendingState implements MachineState{

    @Override
    public void selectProduct(VendingMachine machine, Integer code){
        System.out.println("Already selected, make payemnt");
    }

    @Override
    public void insertMoney(VendingMachine machine,double amount){
        if(machine.intventry.aisles.get(machine.currentSelectedCode).product.price>amount){
            System.out.println("Not enough amount");
            machine.returnChange();
            machine.currentState= machine.IdleState;
            return;
        }
        double price=machine.intventry.aisles.get(machine.currentSelectedCode).product.price;
        double remainingChange=machine.balance-price;
        System.out.println("Remaining change: " + remainingChange);
        System.out.println("First collect product");
        machine.currentState=machine.DispenseState;

    }

    @Override
    public void dispenseProduct(VendingMachine machine){
        System.out.println("First insert money");
    }

    @Override
    public void returnChange(VendingMachine machine){
        System.out.println("First make payment");
    }

    @Override
    public void cancelTransaction(VendingMachine machine){
        System.out.println("Cancelling transcation");
        machine.returnChange();
        machine.currentState=machine.IdleState;
    }



}
