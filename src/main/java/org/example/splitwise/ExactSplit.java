package org.example.splitwise;

import java.util.List;

public class ExactSplit implements SplitStrategy{

    @Override
    public void calculateSplit(Expense expense, List<User> userList, List<Double>percentage, List<Double> exactAmount){

        for(int i=0;i<userList.size();i++){
            SplitDetail split=new SplitDetail(userList.get(i),exactAmount.get(i));
            expense.splitDetails.add(split);
        }
    }
}
