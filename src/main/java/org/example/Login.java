package org.example;

import java.util.Scanner;

public class Login{

    private static Scanner sc = new Scanner(System.in);
    public static void login(){

        Debit gotodebit = new Debit();
        Run gotomain = new Run();

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.print("Enter a new username: "); //check if username exists in database
                    String username = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter password: ");
                    String password = sc.nextLine();
                    //int user_id = registerUser(name, email, password);

                    //userManager.registerUser(username, email, password);

                    System.out.println("Welcome new user!");
                    System.out.println("An automated registration fee of $20 will be debited from your account.");
                    gotodebit.debit(20.00, "Registration Fee");
                    gotomain.main();
                    break;

                case 2:
                    System.out.print("Enter a registered email: ");
                    email = sc.nextLine();
                    System.out.println();

                    System.out.print("Enter password: ");
                    password = sc.nextLine();

                    //userManager.loginUser(email, password);
                    System.out.println();
                    gotomain.main();
                    break;

                case 3:
                    System.out.println("Exiting the system...");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
