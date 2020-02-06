
public class SavingsAccount extends BankAccount {
	private static double rate=0.025;
	private int savingsNumber=0;
	private String accountNumber;
	
	public SavingsAccount(String name, double amount) {
		super(name,amount);
		accountNumber=super.getAccountNumber()+"-"+savingsNumber;
		
	}
	
	public void postInterest() {
		double balance=super.getBalance();
		balance=balance*(rate/12);
		super.deposit(balance);
	}
	@Override
	public String getAccountNumber() {
		return accountNumber;
	}
	public SavingsAccount(SavingsAccount oldAccount, double amount) {
		super(oldAccount,amount);
		savingsNumber=oldAccount.savingsNumber+1;
		accountNumber=super.getAccountNumber()+"-"+savingsNumber;
	}
}
