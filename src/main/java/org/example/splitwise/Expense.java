package org.example.splitwise;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Expense {
    int id;
    double amount;
    User paidBy;
    SplitStrategy splitStrategy;
    List<SplitDetail> splitDetails;
    LocalDate createdAt;
    Group group;

    public Expense(double amount, User paidBy){
        this.id=(int)(Math.random()*1000);
        this.amount=amount;
        this.paidBy=paidBy;
        splitDetails=new ArrayList<>();

        this.createdAt=LocalDate.now();
    }

}
