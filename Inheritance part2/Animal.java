
public class Animal {
	private String name;
	private int age;
	
	public Animal() {
		this("noName", 5);
	}
	public Animal(String name, int age) {
		this.name=name;
		this.age=age;
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
	public String sleep() {
		return "All anaimals sleep";
	}
	public String eat () {
		return "All animals eat";
	}
	@Override
	public String toString() {
		return "Animal:\n name:" +  getName() + ", age:"    + getAge() ;
	}
	
}
