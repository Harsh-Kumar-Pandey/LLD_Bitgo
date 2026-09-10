package org.example.CrytoWallet;

public class Main {
    public static void main(String[] args) {
        CryptoService service=new CryptoService();
        Account acc1=new Account(1,1000.0);
        Account acc2=new Account(2,1000.0);
        service.addAccount(acc1);
        service.addAccount(acc2);

        Transaction transaction=service.initiateTransfer(1,2,500.0);
        System.out.println("Balance of user 1: " + service.viewBalance(1));
        System.out.println("Balance of user 2: " + service.viewBalance(2));

        service.confirmTransaction(transaction.id);
        System.out.println("Balance of user 1 after confirmation: " + service.viewBalance(1));
        System.out.println("Balance of user 2 after confirmation: " + service.viewBalance(2));
        Transaction transaction1=service.initiateTransfer(1,2,500.0);
        System.out.println("Balance of user 1 after second transfer: " + service.viewBalance(1));
        System.out.println("Balance of user 2 after second transfer: " + service.viewBalance(2));
        service.failTransaction(transaction1.id);
        System.out.println("Balance of user 1 after failing transaction: " + service.viewBalance(1));
        System.out.println("Balance of user 2 after failing transaction: " + service.viewBalance(2));
        }
}
