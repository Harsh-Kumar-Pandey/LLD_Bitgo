package org.example.splitwise;

import java.util.List;

public interface SplitStrategy {

    void calculateSplit(Expense expense,List<User>userList, List<Double>percentage, List<Double> exactAmount);
}
