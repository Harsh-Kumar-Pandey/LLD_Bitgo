package org.example.CrytoWallet;

public class Transaction {
    int id;
    int fromUser;
    int toUser;
    double amount;
    TransactionStatus status;

    public Transaction( int fromUser, int toUser, double amount, TransactionStatus status) {
        this.id = (int) (Math.random() * 1000); // Simple ID generation, replace with actual ID generation logic
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.amount = amount;
        this.status = status;
    }

    public String toString(){
        return "Transaction{" +
                "id=" + id +
                ", fromUser=" + fromUser +
                ", toUser=" + toUser +
                ", amount=" + amount +
                ", status=" + status +
                '}';
    }

}
