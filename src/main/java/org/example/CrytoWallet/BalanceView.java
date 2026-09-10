package org.example.CrytoWallet;

public class BalanceView {
    double confirmedBalance;
    double availableBalance;

    public BalanceView(double confirmedBalance, double availableBalance) {
        this.confirmedBalance = confirmedBalance;
        this.availableBalance = availableBalance;
    }

    public String toString(){
        return "BalanceView{" +
                "confirmedBalance=" + confirmedBalance +
                ", availableBalance=" + availableBalance +
                '}';
    }
}
