package org.example;

import java.util.Scanner;
import java.time.LocalDate;

public class Savings {
    private LocalDate startDate, endDate;
    private double savingsPercentage;
    private double savings;
    private Balance balance;
    private double newbalance;

    public void getSavings(double savingsPercentage, double savings){
        this.savingsPercentage = savingsPercentage;
        this.savings = savings;
    }

    public void activateSavings(String activate){

        Scanner sc = new Scanner(System.in);

        if (activate.equalsIgnoreCase("Y")) {
            System.out.print("Please enter the percentage you wish to deduct from the next debit: ");
            savingsPercentage = sc.nextDouble();
            if(savingsPercentage>=0 && savingsPercentage<=100){
                startDate=LocalDate.now();
                endDate=startDate.withDayOfMonth(startDate.lengthOfMonth());
                System.out.println("\n\n\nSavings Settings added successfully!!!");
            } else{
                System.out.println("Invalid percentage.");
                savingsPercentage=0.0;
            }
        } else{
            System.out.println("Savings activation cancelled.");
        }
    }

    public void deactivateSavings(String activate){

        Scanner sc = new Scanner(System.in);

        if (activate.equalsIgnoreCase("Y")) {
            savings = 0.0;
            savingsPercentage = 0.0;
            startDate=null;
            endDate=null;
            System.out.println("\n\n\nSavings Settings removed successfully!!!");
        } else{
            System.out.println("Savings deactivation cancelled.");
        }
    }


    public void endMonthTransferSavings() {
        if(savingsPercentage > 0) {
            if(LocalDate.now().isAfter(endDate) || LocalDate.now().isEqual(endDate)) {
                savings = (savingsPercentage / 100) * balance.getBalance();
                newbalance = balance.getBalance() + savings;
                balance.setBalance(newbalance);

            }
        }
    }

    public void recordSavingsDebited(double amount, String description) {
        if (amount > 0) {
            double savingsAmount = (savingsPercentage / 100) * amount;
            savings += savingsAmount;
            newbalance = balance.getBalance() - amount;
            balance.setBalance(newbalance);
        }
    }
}
