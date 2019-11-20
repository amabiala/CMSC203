
public class Bird extends Animal {
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
	
}
