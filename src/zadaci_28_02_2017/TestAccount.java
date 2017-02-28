package zadaci_28_02_2017;

import java.util.Date;

class Account {
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private Date dateCreated = new Date();

	Account() {
	}

	Account(int id, double balance, double annualInterestRate) {
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}

	public int getId() {
		return this.id;
	}

	public double getMonthlyInterestRate() {
		return this.annualInterestRate / 12.0;
	}

	public double getMonthlyInterest() {
		return this.balance * this.getMonthlyInterestRate();
	}

	public void withdraw(double amount) {
		this.balance -= amount;
	}

	public void deposit(double amount) {
		this.balance += amount;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public double getBalance() {
		return this.balance;
	}
}

public class TestAccount {

	public static void main(String[] args) {
		Account account = new Account(1122, 20000, 4.5);
		System.out.println("Account created on " + account.getDateCreated());
		System.out.println("Balance: " + account.getBalance() + "$");
		account.withdraw(2500);
		System.out.println("Withdrow 2,500$, new balance: " + account.getBalance() + "$");
		account.deposit(3000);
		System.out.println("Deposit 3,000$, new balance: " + account.getBalance() + "$");
		System.out.println("Monthly interest rate: " + account.getMonthlyInterestRate());
		System.out.println("Monthly interest: " + account.getMonthlyInterest());

	}

}
