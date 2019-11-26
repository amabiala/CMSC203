public class Bird extends Animal implements Sellable{
	private boolean hasFeather;

	public Bird() {
		super();
		hasFeather=true;
	}

	public Bird(String name, int age, boolean hasFeather) {
		super(name, age);
		this.hasFeather=hasFeather;
		
	}
	public String fly() {
		return "All birds can fly";
	}
	@Override
	public String sleep() {
		return "All birds sleep in trees";
	}
	@Override
	public String eat() {
		return "Birds eat grain";
	}

	@Override
	public String toString() {
		if(hasFeather) {
			return "Bird: \n" + super.toString() +"\nit has feathers";
		}
		return "Bird: \n" + super.toString();
	}

	@Override
	public double sellWithDiscount(int per) {
		
		return per*1000;
	}

	@Override
	public String sellInternational(String country) {
		
		return "The Bird is sold to "+country;
	}
	
}