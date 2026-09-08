package org.example.splitwise;

import java.util.ArrayList;
import java.util.List;

public class Group {
    int id;
    String groupName;
    List<User>members;
    List<Expense> expenses;

    public Group(String groupName, List<User>members){
        this.id=(int)(Math.random()*1000);
        this.groupName=groupName;
        this.members=members;
        expenses=new ArrayList<>();
    }
    public void addExpense(Expense expense){
        expenses.add(expense);
    }



}
