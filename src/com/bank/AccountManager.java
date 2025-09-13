package com.bank;

import java.util.HashMap;
import java.util.Map;

class AccountManager {
    private Map<String, Account> accounts = new HashMap<>();

    public void createAccount(String accNo, String holderName, double balance) {
        if (accounts.containsKey(accNo)) {
            System.out.println("Account already exists!");
        } else {
            accounts.put(accNo, new Account(accNo, holderName, balance));
            System.out.println("Account created successfully!");
        }
    }

    public void deposit(String accNo, double amount) {
        Account acc = accounts.get(accNo);
        if (acc != null) acc.deposit(amount);
        else System.out.println("Account not found!");
    }

    public void withdraw(String accNo, double amount) {
        Account acc = accounts.get(accNo);
        if (acc != null) acc.withdraw(amount);
        else System.out.println("Account not found!");
    }

    public void transfer(String fromAcc, String toAcc, double amount) {
        Account from = accounts.get(fromAcc);
        Account to = accounts.get(toAcc);

        if (from != null && to != null) {
            if (from.getBalance() >= amount) {
                from.withdraw(amount);
                to.deposit(amount);
                System.out.println("Transferred " + amount + " from " + fromAcc + " to " + toAcc);
            } else {
                System.out.println("Insufficient funds in source account!");
            }
        } else {
            System.out.println("One or both accounts not found!");
        }
    }

    public void showAccount(String accNo) {
        Account acc = accounts.get(accNo);
        if (acc != null) acc.displayDetails();
        else System.out.println("Account not found!");
    }

    public void showAllAccounts() {
        if (accounts.isEmpty()) System.out.println("No accounts available!");
        else {
            for (Account acc : accounts.values()) acc.displayDetails();
        }
    }
}
