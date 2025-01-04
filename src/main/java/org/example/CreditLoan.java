package org.example;

import java.time.LocalDateTime; //used in date n time setting
import java.time.format.DateTimeFormatter;//used in date n time setting
import java.time.LocalDate;
public class CreditLoan {

    private LocalDateTime startDate;
    private double monthlyBalance;
    private Run gotomain = new Run();

    public CreditLoan(){
    }
    public CreditLoan(double monthlyPayment,LocalDateTime startDate){
        this.monthlyBalance = monthlyPayment;
        this.startDate = startDate;
    }

    public LocalDateTime getStartDate(){
        return startDate;
    }

    public void repaymentPeriod(double pAmount, double rate, int period){
        double totalRepayment = pAmount+(pAmount*(rate/100));
        double monthlyPayment = totalRepayment/period;

        System.out.println("Your loan amount is : "+pAmount);
        System.out.println("Your total repayment expected is "+totalRepayment+" for a period of "+period+" months with a rate of "+rate+" included.");
        System.out.println("Monthly payment to be made : "+monthlyPayment);

        Reminder reminder = new Reminder(getStartDate(), monthlyPayment);
        reminder.updateStartDate(getStartDate());
    }

    public void loanBalance(LocalDateTime startDate, double amount){
        System.out.println("Loan balance is : "+monthlyBalance);
        System.out.println("Loan balance after payment is : "+(monthlyBalance-amount));
        monthlyBalance-=amount;

    }

    public static String currentTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dtf.format(now);
    }

    public LocalDateTime barredUsage(LocalDateTime startDate){
        LocalDateTime now = LocalDateTime.now();
        long daysBetween = java.time.Duration.between(startDate, now).toDays(); // Calculate days between

        if (daysBetween >= 30) { // check whether at least 30 days have passed
            if (monthlyBalance > 0) { //if got balance left unpaid
                System.out.println("Credit and debit usage is barred due to late payment.\nWe apologize for any inconvenience caused.");
                gotomain.main();


            } else {//if dont got balance
                System.out.println("No outstanding balance.");
            }
            System.out.println("Thank you for patience and understanding.");

            return startDate = now;//set new startDate ONLY if passed 30 days

        } else { //count how many days in between now to next payment
            long nextPayment;
            nextPayment = 30-daysBetween; //30 days set between each month
            System.out.println("Number of days till next monthly payment due is " +nextPayment);
            System.out.println("\n\n");
        }
        return startDate;
    }
}
