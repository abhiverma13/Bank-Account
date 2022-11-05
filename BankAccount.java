
public class BankAccount {
	private String accountNumber;
	private double balance;
	private double withdrawalFee;
	private double annualInterestRate;
	
	//Constructors
	public BankAccount(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BankAccount(String accountNumber, double initialBalance) {
		this.accountNumber = accountNumber;
		this.balance = initialBalance;
	}
	public BankAccount(String accountNumber, double initialBalance, double withdrawalFee, double annualInterestRate) {
		this.balance = initialBalance;
		this.accountNumber = accountNumber;
		this.withdrawalFee = withdrawalFee;
		this.annualInterestRate = annualInterestRate;
	}
	
	//Getters and Setters
	public String getAccountNumber() {
		return accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public double getWithdrawalFee() {
		return withdrawalFee;
	}
	public void setWithdrawalFee(double withdrawalFee) {
		this.withdrawalFee = withdrawalFee;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	//methods
	public void deposit(double amount) {
		this.balance = this.balance+amount;
	}
	public void withdraw(double amount) {
		this.balance = this.balance - this.withdrawalFee - amount;
	}
	public boolean isOverDrawn() {
		return(balance<0);
	}
	public String toString() {
		if (this.balance<0) {
			this.balance = Math.abs(this.balance);
			String stringBalance = String.format("%.02f", this.balance);
			return("BankAccount "+this.accountNumber+ ": " +"($"+stringBalance+")");
		}
		else {
			String stringBalance = String.format("%.02f", this.balance);
			return("BankAccount "+this.accountNumber+ ": " +"$"+stringBalance);
		}
	}
	
}
