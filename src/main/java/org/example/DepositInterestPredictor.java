package org.example;

public class DepositInterestPredictor {

    Balance balance = new Balance();
    Run gotomain = new Run();
    double interestRate = 0;
    double rhbRate = 0.05;
    double maybankRate = 0.06;
    double hongLeongRate = 0.07;
    double allianceRate = 0.08;
    double amBankRate = 0.09;
    double standardCharteredRate = 0.10;

    public double predictInterestRate(int bankChoice) {


        switch (bankChoice) {
                case 1 -> interestRate = rhbRate;
                case 2 -> interestRate = maybankRate;
                case 3 -> interestRate = hongLeongRate;
                case 4 -> interestRate = allianceRate;
                case 5 -> interestRate = amBankRate;
                case 6 -> interestRate = standardCharteredRate;
                default -> {
                    System.out.println("Invalid choice. Please select a valid bank.");
                    gotomain.main();

                }
        }
        return balance.getBalance() * interestRate;
    }
}