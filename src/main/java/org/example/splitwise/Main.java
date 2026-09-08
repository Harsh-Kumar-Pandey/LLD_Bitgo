package org.example.splitwise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SplitWiseManager manager=new SplitWiseManager();
        User user1=new User(1,"Harsh");
        User user2=new User(2,"Aaysh");
        User user3=new User(3,"Amandeep");
        List<User> members=new ArrayList<>();
        members.add(user1);
        members.add(user2);
        members.add(user3);
        Group group=new Group("Test Group", members);
       SplitStrategy equalSplit=new EqualSplit();
       SplitStrategy percentageSplit=new PercentageSplit();

        //manager.addExpense(group,equalSplit,user1,1000.0);
        manager.addExpense(group,equalSplit,user2,500.0);

       // manager.addExpense(group,percentageSplit,user2, Arrays.asList(20.0,30.0,50.0),100.0);
        manager.getBalanceSheet();
    }
}
