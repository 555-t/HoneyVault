package org.example;

import org.w3c.dom.ls.LSOutput;

public class Balance {
    private double balance;

    public Balance(){
        balance = 0.0;
    }

    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
}
