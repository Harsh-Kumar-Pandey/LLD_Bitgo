package org.example.splitwise;

import java.util.List;

public class PercentageSplit implements SplitStrategy{
    @Override
    public void calculateSplit(Expense expense, List<User> members, List<Double> percentages, List<Double> amounts) {

        double sum=0.0;
        if(percentages==null){
            throw new IllegalArgumentException("percentage details not provided for split");
        }
        for(Double percentage : percentages) {
            sum += percentage;
        }
        if(sum!=100.0){
            throw new IllegalArgumentException("Invalid split");
        }

        for(int i=0;i<members.size();i++){
            User user=members.get(i);
            Double percentage=percentages.get(i);
            Double amount=(percentage/100)*expense.amount;
            expense.splitDetails.add(new SplitDetail(user,amount));
        }
    }
}
