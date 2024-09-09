package miniProjectBankApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Bank {
	private final List<Account> bankAccounts;
	private final Scanner sc;

	public Bank() {
		bankAccounts = new ArrayList<>();
		sc = new Scanner(System.in);
	}

	public Account isAccountExist(int accountID, String phoneNumber) {
		for (Account account : bankAccounts) {
			if (account.getID() == accountID && account.getPhoneNumber().equals(phoneNumber)) {
				return account;
			}
		}
		System.out.println("One of the details is incorrect");
		return null;
	}

	public Account isAccountExist(String phoneNumber) {
		for (Account account : bankAccounts) {
			if (account.getPhoneNumber().equals(phoneNumber)) {
				return account;
			}
		}
		return null;
	}

	public static boolean isPhoneNumberCorrect(String phoneNumber) {
		if (phoneNumber.length() != 10) {
			System.out.println("Phone number must be 10 digits.");
			return false;

		} else {
			return true;
		}
	}

	public void registerAccount() {
		System.out.println("---------Account Registration---------");
		System.out.println("First name?");
		String firstName = sc.next();
		System.out.println("Last name?");
		String lastName = sc.next();
		System.out.println("Phone number?");
		String phoneNumber = sc.next();

		if (isPhoneNumberCorrect(phoneNumber)) {
			bankAccounts.add(new Account(firstName, lastName, phoneNumber));
			System.out.println("You have created account successfully!" + "\n" + "Your account ID is: "
					+ bankAccounts.get(bankAccounts.size() - 1).getID());

		}
	}

	public void loginAccount() throws InsufficientBalanceException, NegativeAmountException {
		System.out.println("---------Account Login---------");
		System.out.println("Please enter your accountID:");
		int accountID = 0;
		while (true) {
			try {
				accountID = sc.nextInt();
				break;
			} catch (NoSuchElementException e) {
				sc.nextLine();
			}
		}
		System.out.println("Please enter your phone number:");
		String phoneNumber = sc.next();
		if (isPhoneNumberCorrect(phoneNumber)) {
			Account selectedAccount = isAccountExist(accountID, phoneNumber);
			boolean exitRequested = false;
			while (!exitRequested) {
				try {
					if (selectedAccount.equals(null)) {
					} else {
						PrintService.existAccountMenu();
					}
				} catch (Exception e) {
					System.err.println("Invalid Login Inputs");
				}
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println(selectedAccount.toString());
					break;
				case 2:
					System.out.println("Please enter deposit amount:");
					double depositAmount = sc.nextDouble();
					selectedAccount.depositMoney(depositAmount);
					break;
				case 3:
					System.out.println("Please enter withdrawal amount:");
					double withdrawalAmount = sc.nextDouble();
					selectedAccount.withdrawMoney(withdrawalAmount);
					break;
				case 4:
					System.out.println("Please enter the phone number of the account you want to transfer money: ");
					String accountPhoneNumber = sc.next();
					if (isPhoneNumberCorrect(accountPhoneNumber)) {
						Account accountToTransfer = isAccountExist(accountPhoneNumber);
						System.out.println("Enter the amount of money you would like to transfer:");
						double moneyToTransfer = sc.nextDouble();
						selectedAccount.transferMoneyTo(selectedAccount, accountToTransfer, moneyToTransfer);
						break;
					}
				case 5:
					exitRequested = true;
					break;
				default:
					System.out.println("Wrong input");
					break;
				}
			}
		}
	}

}
