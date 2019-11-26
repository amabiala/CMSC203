public abstract class Animal {
	private String name;
	private int age;
	
	public Animal() {
		name="Some name";
		age=5;
	}
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String eat() {
		return "Animals eat";
	}
	public abstract String sleep();

	@Override
	public String toString() {
		return "Name: " + getName() + "\nAge: " + getAge() ;
	}
	
	
}