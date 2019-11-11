
public class Bird extends Animal{
	private boolean hasFeather;
	
	
	public Bird(String name, int age, boolean hasFeather) {
		super(name, age);
		hasFeather=true;
	}

	@Override
	public String eat() {
		return "All bird eat grain";
	}
	
	@Override
	public String toString() {
		return "Bird:\n name: " + getName() + "\nFeather: "+ hasFeather + "\nAge: " + getAge() ;
	}
	
}
