package org.example;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Reminder {
    private LocalDateTime startDate;
    private double outstanding_balance;
    private boolean isAlertShown;

    public Reminder(){}

    public Reminder(LocalDateTime startDate, double outstanding_balance){
        this.startDate = startDate;
        this.outstanding_balance = outstanding_balance;
        this.isAlertShown = false;
    }
    public void checkAndShowReminder(){
        if(outstanding_balance <=0){
            return; // no reminder needed if no balance
        }

        LocalDateTime now = LocalDateTime.now();
        long daysUntilDue = ChronoUnit.DAYS.between(now, startDate);

        if(!isAlertShown){ // show reminder only once per login session
            if(daysUntilDue <=0){
                System.out.println("\n=== PAYMENT REMINDER ===");
                System.out.println("Your loan payment of RM"+ String.format("%.2f", outstanding_balance)+ " is OVERDUE.");
                System.out.println("Please make the payment as soon as possible to avoid account restrictions.");
                System.out.println("==========================\n");

            } else if(daysUntilDue <= 7){
                System.out.println("\n=== PAYMENT REMINDER ===");
                System.out.println("Your next loan payment of RM"+ String.format("%.2f", outstanding_balance)+ " is due in "+ daysUntilDue + " days.");
                if(daysUntilDue <= 3){
                    System.out.println("please ensure timely payment to avoid account restrictions.");

                }
                System.out.println("==========================\n");
            } else if (daysUntilDue <= 14){
                System.out.println("\n=== PAYMENT REMINDER ===");
                System.out.println("Your next loan payment of RM"+ String.format("%.2f", outstanding_balance)+ " is due in "+ daysUntilDue + " days.");
                System.out.println("==========================\n");
            }
            isAlertShown = true;
        }
    }

    public void updateStartDate(LocalDateTime newStartDate){
        this.startDate = newStartDate;
    }

    public void updateBalance(double newBalance){
        this.outstanding_balance = newBalance;
    }

    public void resetAlertFlag(){
        this.isAlertShown = false;
    }


}
