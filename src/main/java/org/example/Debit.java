package org.example;

import java.util.Scanner;

public class Debit {

    private boolean descTrue, debTrue;

    //used as while loop for description
    public Debit() {
        descTrue = true;
        debTrue = true;
    }
    //used as while loop for credit n debit transferring

    public void debit(double amount, String description){
        while(debTrue){

            if(amount>0 && amount<100000){
                //add in database for sql here
                debTrue = false;
            }else{
                System.out.println("Please enter a valid amount.");
            }
        }

        while(descTrue){
            if(description.length()>100 ){// case : user writes description over 100
                System.out.println("Oh no, you have exceeded our maximum count. Please try again.");

            }else {
                System.out.println("");//add in database for sql here
                descTrue = false;
                System.out.println("Debit Successfully Recorded.");
                System.out.println("Thank you for using Ledger System");
                System.out.println();

            }

        }

    }
}
