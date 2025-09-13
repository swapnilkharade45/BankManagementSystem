package com.bank;

import java.util.Scanner;

public class AccountManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountManager manager = new AccountManager();

        while (true) {
            System.out.println("\n--- Account Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Show Account");
            System.out.println("6. Show All Accounts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            if (sc.hasNextInt()) choice = sc.nextInt();
            else {
                sc.next(); // consume invalid token
                System.out.println("Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Account No: ");
                    String accNo = sc.next();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();
                    manager.createAccount(accNo, name, bal);
                    break;

                case 2:
                    System.out.print("Enter Account No: ");
                    accNo = sc.next();
                    System.out.print("Enter Amount to Deposit: ");
                    double dep = sc.nextDouble();
                    manager.deposit(accNo, dep);
                    break;

                case 3:
                    System.out.print("Enter Account No: ");
                    accNo = sc.next();
                    System.out.print("Enter Amount to Withdraw: ");
                    double wd = sc.nextDouble();
                    manager.withdraw(accNo, wd);
                    break;

                case 4:
                    System.out.print("Enter Source Account No: ");
                    String from = sc.next();
                    System.out.print("Enter Destination Account No: ");
                    String to = sc.next();
                    System.out.print("Enter Amount to Transfer: ");
                    double amt = sc.nextDouble();
                    manager.transfer(from, to, amt);
                    break;

                case 5:
                    System.out.print("Enter Account No: ");
                    accNo = sc.next();
                    manager.showAccount(accNo);
                    break;

                case 6:
                    manager.showAllAccounts();
                    break;

                case 7:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
