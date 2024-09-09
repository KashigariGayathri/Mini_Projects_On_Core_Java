package miniProjectBankApplication;

import java.util.Scanner;

public class MainPage {
	public static void main(String[] args) throws InsufficientBalanceException, NegativeAmountException {
		Scanner sc = new Scanner(System.in);
		Bank bank = new Bank();
		boolean exitRequested = false;
		System.out.println("********************************************");
		System.out.println("*      Welcome to State Bank of India      *");
		System.out.println("********************************************");
		while (!exitRequested) {
			PrintService.printMenu();
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				bank.registerAccount();
				break;
			case 2:
				bank.loginAccount();
				break;
			case 3:
				exitRequested = true;
				break;
			default:
				System.out.println("Your input was not recognized. Please try again.");
				break;
			}
		}
	}
}
