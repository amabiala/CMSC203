
public class CheckingAccount extends BankAccount {
	private static final double FEE=0.15;
	
	public CheckingAccount(String name, double amount) {
		super(name,amount);
		String accountNumber=super.getAccountNumber()+"-10";
		super.setAccountNumber(accountNumber);
	}
	@Override
	public boolean withdraw(double amount) {
		boolean complete=true;
		amount+=FEE;
		complete=super.withdraw(amount);
		return complete;
	}
}
