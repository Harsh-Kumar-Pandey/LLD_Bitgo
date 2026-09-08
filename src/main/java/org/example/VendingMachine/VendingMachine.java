package org.example.VendingMachine;

public class VendingMachine {
    public final MachineState IdleState;
    public final MachineState DispenseState;
    public final MachineState paymentPendingState;
    public final MachineState returnChangeState;
    public MachineState currentState;
    public Intventry intventry;
    public double balance;
    public Integer currentSelectedCode;



    public  VendingMachine(){
        IdleState=new IdleState();
        DispenseState=new DispenseState();
        paymentPendingState=new paymentPendingState();
        returnChangeState=new returnChangeState();
        intventry=new Intventry();
        currentState=IdleState;
        this.balance=0.0;

    }

    public void returnChange(double amount){
        System.out.println("Returning remaining money=> "+amount);
        this.balance=0.0;
    }
    public void returnChange(){
        System.out.println("Returning remaining money=> "+balance);
        this.balance=0.0;
    }


    public void selectProduct(int code){
        currentSelectedCode=code;
        currentState.selectProduct(this,code);
    }

    public void insertMoney(double amount){
        this.balance=amount;
        currentState.insertMoney(this,amount);
    }

    public void dispense(){
        currentState.dispenseProduct(this);
    }



    public void cancel(){
        currentState.cancelTransaction(this);
    }


    public Intventry getInventory() {
        return intventry;
    }
}
