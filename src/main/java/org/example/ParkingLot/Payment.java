package org.example.ParkingLot;

import java.time.LocalTime;

public class Payment {
    int id;
    double amount;
    PaymentStatus status;
    LocalTime paymentTime;

    public void processPayment(double amount){
        System.out.println("Payment success full");
        this.amount=amount;
        paymentTime=LocalTime.now();
        status=PaymentStatus.SUCCESS;
    }

    public String toString(){
        System.out.println("Payment ID: " + id + ", Amount: " + amount + ", Status: " + status + ", Payment Time: " + paymentTime);
        return "Payment ID: " + id + ", Amount: " + amount + ", Status: " + status + ", Payment Time: " + paymentTime;
    }

}
