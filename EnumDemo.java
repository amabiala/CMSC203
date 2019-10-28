
public class EnumDemo {
	public enum Dog {POODLE, BOXER, TERRIER}
	
	public static void main(String[] args) {
		System.out.println(Dog.POODLE+"\n"+Dog.BOXER+"\n"+Dog.TERRIER);
		System.out.println(Dog.POODLE.ordinal()+"\n"+Dog.BOXER.ordinal()+"\n"+Dog.TERRIER.ordinal());
		Dog myDog=Dog.BOXER;
		if (myDog.compareTo(Dog.TERRIER)>0)
			System.out.println(myDog+" is greater than "+Dog.TERRIER);
		else
			System.out.println(myDog+" is NOT greater than "+Dog.TERRIER);
	}

}
