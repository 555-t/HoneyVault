package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    LocalDate DateInMain = LocalDate.now();



    public static void main(String[] args) {
        Run run = new Run();
        Login userlogin = new Login();
        Reminder reminder = new Reminder();

        userlogin.login();
        reminder.checkAndShowReminder();
        run.main();

    }


}

class Run {
    LocalDate DateInMain = LocalDate.now();

    public void main() {
        double amount;
        String description;

        Scanner sc = new Scanner(System.in);
        int choice;

        Logout userlogout = new Logout();
        Debit debit = new Debit();
        Credit credit = new Credit();
        Date date = new Date();
        Savings savings = new Savings();
        CreditLoan creditLoan = new CreditLoan();
        Reminder reminder = new Reminder();
        Balance balance = new Balance();
        DepositInterestPredictor dip = new DepositInterestPredictor();


        do {
            System.out.println("== Transaction Menu ==");
            System.out.println("1. Debit");
            System.out.println("2. Credit");
            System.out.println("3. History");
            System.out.println("4. Savings");
            System.out.println("5. Credit Loan");
            System.out.println("6. Deposit Interst Predictor");
            System.out.println("7. Logout");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("== Debit ==");

                    date.dateValidationPayment(DateInMain);
                    creditLoan.barredUsage(creditLoan.getStartDate());
                    System.out.println("Enter the amount to debit: ");
                    amount = Double.parseDouble(sc.nextLine());
                    System.out.println("Enter the description: ");
                    description = sc.nextLine();
                    debit.debit(amount, description);

                    break;

                case 2:
                    System.out.println("== Credit ==");

                    date.dateValidationPayment(DateInMain);
                    System.out.println("Enter the amount to debit: ");
                    amount = Double.parseDouble(sc.nextLine());
                    System.out.println("Enter the description: ");
                    description = sc.nextLine();
                    credit.credit(amount, description);
                    break;


                case 3:
                    System.out.println("== History ==");
                    break;

                case 4:
                    System.out.println("== Savings ==");

                    System.out.println("1. Activate Savings");
                    System.out.println("2. Disable Savings");
                    int savingsChoice = sc.nextInt();
                    if (savingsChoice != 1) {
                        System.out.print("Are you sure you want to activate new savings? (Y/N) : ");
                        String activate = sc.nextLine();
                        savings.activateSavings(activate);
                    } else {
                        System.out.println("Are you sure you want to deactivate savings? (Y/N) :");
                        String activate = sc.nextLine();
                        savings.deactivateSavings(activate);
                    }
                    break;

                case 5:
                    System.out.println("== Credit Loan ==");
                    System.out.println("1. Apply for a loan");
                    System.out.println("2. Pay off loan");
                    System.out.println("3. View remainder loan for this month");
                    int loanChoice = sc.nextInt();
                    if (loanChoice == 1) {
                        System.out.print("Enter a specified principal amount:RM ");
                        double pAmount = sc.nextDouble();
                        System.out.print("Enter interest rate (in %): ");
                        double rate = sc.nextDouble();
                        System.out.print("Enter repayment period (in month): ");
                        int period = sc.nextInt();
                        LocalDateTime startDate = LocalDate.now().atStartOfDay();

                        System.out.println("Loan Application Successful!");

                        creditLoan.repaymentPeriod(pAmount, rate, period);
                    } else if (loanChoice == 2) {

                    }else if (loanChoice == 3){

                    }
                    break;

                case 6:
                    System.out.println("== Deposit Interest Predictor ==");
                    System.out.printf("Your current balance is RM %.2f%n" + balance.getBalance());

                    System.out.print("Latest Bank Rates ");
                    System.out.println("1. RHB (2.6%)");
                    System.out.println("2. Maybank (2.5%)");
                    System.out.println("3. Hong Leong (2.3%)");
                    System.out.println("4. Alliance (2.85%)");
                    System.out.println("5. AmBank (2.55)");
                    System.out.println("6. Standard Chartered (2.65%)");
                    System.out.print("Enter your choice (1-6): ");
                    int bankChoice = sc.nextInt();

                    dip.predictInterestRate(bankChoice);
                    break;

                case 7:
                    userlogout.logout(); //exit
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (choice != 7); //continue loop until logout


    }

}



