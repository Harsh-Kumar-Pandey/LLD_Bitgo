package org.example.splitwise;

import java.util.List;

public class EqualSplit implements SplitStrategy{

    @Override
    public void calculateSplit(Expense expense,List<User>userList, List<Double> percentage, List<Double> exactAmount){
        double exactSplitAmount= expense.amount/ userList.size();

        for(User user:userList){
            SplitDetail split=new SplitDetail(user,exactSplitAmount);
            expense.splitDetails.add(split);
        }

    }
}
