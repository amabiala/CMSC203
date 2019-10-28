
public class BankAccount {
	private double balance;
	private static double interestRate;
	
	public static double getInterestRate() {
		return interestRate;
	}
	public static void setInterestRate(double ir) {
		interestRate=ir;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance=balance;
	}
}
