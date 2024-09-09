package miniprojectATM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATMMiniProject {
    private static double balance = 20000.0; // Represents the account balance
    private static String currentPin = "1218"; // Current PIN
    private static Scanner scanner = new Scanner(System.in); // A Scanner object to read user input
    private static boolean login = false; // A boolean flag to track whether the user is logged in
    private static List<String> transactionHistory = new ArrayList<>(); // List to store transaction history

    public static void main(String[] args) {
        while (true) { // It runs in an infinite loop
            if (!login) {
                login();
            } else {
                displayMenu();
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                processChoice(choice);
            }
        }
    }

    private static void login() {
        System.out.print("Enter your PIN: ");
        String enteredPin = scanner.nextLine();

        if (currentPin.equalsIgnoreCase(enteredPin)) {
            login = true;
            System.out.println("PIN accepted. You are logged in.");
        } else {
            System.out.println("Incorrect PIN. Please try again.");
        }
    }

    private static void displayMenu() {
        System.out.println("\nWelcome to the ATM!");
        System.out.println("SUDHEER ENAGANDULA");
        System.out.println("Choose an option: ");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer to Bank");
        System.out.println("5. Change PIN");
        System.out.println("6. Transaction History");
        System.out.println("7. Cancel");
        System.out.println("8. Exit");
    }

    private static void processChoice(int choice) {
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                transferToBank();
                break;
            case 5:
                changePin();
                break;
            case 6:
                displayTransactionHistory();
                break;
            case 7:
                System.out.println("Cancelled successfully.");
                break;
            case 8:
                System.out.println("Thank you! Exiting...");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    private static void changePin() {
        System.out.print("Enter your current PIN: ");
        String enteredPin = scanner.nextLine();
        if (currentPin.equalsIgnoreCase(enteredPin)) {
            System.out.print("Enter your new PIN: ");
            String newPin = scanner.nextLine();
            currentPin = newPin;
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Incorrect PIN. PIN change failed.");
        }
    }

    private static void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    private static void transferToBank() {
        System.out.print("Enter the transfer amount: ");
        double transferAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        if (transferAmount > 0 && transferAmount <= balance) {
            balance -= transferAmount;
            transactionHistory.add("Transferred to bank: " + transferAmount);
            System.out.println("Money transferred successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount. Transfer failed.");
        }
    }

    private static void checkBalance() {
        System.out.println("Your balance is: " + balance);
    }

    private static void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn: " + amount);
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount. Withdrawal failed.");
        }
    }

    private static void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount. Deposit failed.");
        }
    }
}
