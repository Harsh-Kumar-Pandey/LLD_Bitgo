package org.example.splitwise;

public class SplitDetail {
    int id;
    User user;
    double amount;

    public SplitDetail(User user, double amount){
        this.id=(int)(Math.random()*1000);
        this.user=user;
        this.amount=amount;
    }
}
