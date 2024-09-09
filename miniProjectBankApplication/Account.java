package miniProjectBankApplication;

public class Account {
	private final String firstName;
	private final String lastName;
	private double balance;
	private static int uid = 0;
	private final String phoneNumber;
	private final int id;

	public Account(String firstName, String lastName, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.balance = 0.0;
		uid++;
		this.id = uid;
	}

	public String getFirstName() {
		return this.firstName + "";
	}

	public String getLastName() {
		return this.lastName + "";
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double newBalance) {
		this.balance = newBalance;
	}

	public int getID() {
		return this.id;
	}

	public String getPhoneNumber() {
		return this.phoneNumber + "";
	}

	public void depositMoney(double depositAmount) {
		this.balance += depositAmount;
		System.out.println(
				"You have deposit " + depositAmount + " to your account." + "\n" + "Balance is now: " + this.balance);
	}

	public void withdrawMoney(double withdrawalAmount) throws InsufficientBalanceException, NegativeAmountException {
		if (withdrawalAmount < 0) {
			throw new NegativeAmountException("Negative withdrawalAmount");
		} else if (this.balance < withdrawalAmount) {
			throw new InsufficientBalanceException("Not enough funds to withdraw");
		} else {
			this.balance -= withdrawalAmount;
			System.out.println("You have withdrawal " + withdrawalAmount + " from your account." + "\n"
					+ "Balance is now: " + this.balance);
		}

	}

	public void transferMoneyTo(Account thisAccount, Account toAccount, double amountToTransfer)
			throws InsufficientBalanceException, NegativeAmountException {
		if (amountToTransfer < 0) {
			throw new NegativeAmountException("Negative amountToTransfer");
		} else if (this.balance < amountToTransfer) {
			throw new InsufficientBalanceException("Not enough funds to transfer");
		} else {
			toAccount.setBalance(toAccount.balance += amountToTransfer);
			thisAccount.setBalance(this.balance -= amountToTransfer);
		}
		System.out.println("Amount transferred to the account successfully!" + "\nBalance is now: " + this.balance);
	}

	@Override
	public String toString() {
		return "First Name: " + getFirstName() + "\nLast Name: " + getLastName() + "\nBalance: " + getBalance()
				+ "\nID: " + getID();
	}

}
