package org.example.CrytoWallet;

import java.util.concurrent.locks.ReentrantLock;

public class Account {
    final int userId;
    double confirmedBalance;
    double pendingHolds;
    final ReentrantLock lock=new ReentrantLock();

    public Account(int userId, double confirmedBalance) {
        this.userId = userId;
        this.confirmedBalance = confirmedBalance;
        this.pendingHolds = 0.0;
    }

    public double getConfirmedBalance() {
        System.out.println("Confirmed Balance: " + confirmedBalance);
        return confirmedBalance;
    }

    public double getPendingHolds() {
        System.out.println("Pending Holds: " + pendingHolds);
        return pendingHolds;
    }
    public double getAvailableBalance() {
        System.out.println("Available Balance: " + (confirmedBalance -pendingHolds));
        return confirmedBalance - pendingHolds;
    }

    public boolean reserveFunds(double amount){

        if(getAvailableBalance()>=amount){
            pendingHolds=pendingHolds+amount;
            return true;
        }
        return false;
    }

    public void releaseReserve(double amount) {
            pendingHolds -= amount;
    }

    public void deductConfirmed(double amount) {
        confirmedBalance -= amount;
        pendingHolds-=amount;
    }
    public void addConfirmed(double amount) {
        confirmedBalance += amount;
    }
}
