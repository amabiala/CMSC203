
public class BankAccountDemo {

	public static void main(String[] args) {
		BankAccount a=new BankAccount ();
		a.setBalance(195.15);
		BankAccount b=new BankAccount();
		b.setBalance(200.45);
		
		BankAccount.setInterestRate(3.75);
		System.out.println("First: $"+a.getBalance());
		System.out.println("second: $"+b.getBalance());
		
		System.out.println("Interest rate is: "+BankAccount.getInterestRate()+"%");
	}

}
