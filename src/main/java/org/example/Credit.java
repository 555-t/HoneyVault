package org.example;

public class Credit {

    private boolean descTrue,credTrue;

    //used as while loop for description
    public Credit() {
        descTrue = true;
        credTrue = true;
    }
    //used as while loop for credit n debit transferring

    public void credit(double amount, String description){
        while(credTrue){

            if(amount>0 && amount<100000){
                //add in database for sql here
                credTrue = false;
            }else{
                System.out.println("Please enter a valid amount.");
            }
        }

        while(descTrue){
            if(description.length()>100 ){// case : user writes description over 100
                System.out.println("Oh no, you have exceeded our maximum count. Please try again.");

            }else {
                System.out.println();//add in database for sql here
                descTrue = false;
                System.out.println("Debit Successfully Recorded!!!");

            }

        }
    }
}

