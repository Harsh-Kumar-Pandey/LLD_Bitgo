package org.example.splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitWiseManager {

    Map<User, Map<User,Double>>balances;
    Map<Integer,User>users;
    Map<Integer, Expense>expenses;
    Map<Integer, Group> gropus;

    public SplitWiseManager(){
        balances=new HashMap<>();
        users=new HashMap<>();
        expenses=new HashMap<>();
        gropus=new HashMap<>();
    }

    public void addUser(User user){
        users.put(user.id,user);
    }
    public void addExpense(Expense expense){
        expenses.put(expense.id,expense);
    }
    public void addGroup(Group group){
        gropus.put(group.id,group);
    }

    public void addExpense(Group group,SplitStrategy splitStrategy,User paidBy,double amount){
        Expense exp=new Expense(amount,paidBy);
        exp.group=group;
        expenses.put(exp.id,exp);
        gropus.put(group.id,group);

        exp.splitStrategy=splitStrategy;
        exp.splitStrategy.calculateSplit(exp,group.members,null,null);
        group.addExpense(exp);
        for(SplitDetail splitDetail:exp.splitDetails){
            setBalances(splitDetail.user,exp.paidBy,splitDetail.amount);
        }

    }
    public void addExpense(Group group,SplitStrategy splitStrategy,User paidBy,List<Double>percentage,double amount){
        Expense exp=new Expense(amount,paidBy);
        exp.group=group;
        expenses.put(exp.id,exp);
        gropus.put(group.id,group);

        exp.splitStrategy=splitStrategy;
        exp.splitStrategy.calculateSplit(exp,group.members,percentage,null);
        group.addExpense(exp);
        for(SplitDetail splitDetail:exp.splitDetails){
            setBalances(exp.paidBy,splitDetail.user,splitDetail.amount);
        }

    }

    public void setBalances(User user,User otherUser, double amount){

        if(!balances.containsKey(user)) balances.put(user,new HashMap<>());
        if(!balances.containsKey(otherUser)) balances.put(otherUser,new HashMap<>());

        balances.get(user).put(otherUser,balances.get(user).getOrDefault(otherUser,0.0)+amount);
        balances.get(otherUser).put(user,balances.get(otherUser).getOrDefault(user,0.0)-amount);
    }

    public void getBalanceSheet(){
        for(Map.Entry<User, Map<User, Double>> entry : balances.entrySet()) {
            User user = entry.getKey();
            Map<User, Double> userBalances = entry.getValue();
            System.out.println("User: " + user.name+" :");
            for(Map.Entry<User, Double> balanceEntry : userBalances.entrySet()) {
                User otherUser = balanceEntry.getKey();
                Double balance = balanceEntry.getValue();
                System.out.println("   -> " + otherUser.name + ": " + balance);
            }
        }
    }

}
