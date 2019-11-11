
public class InheritanceDemo {

	public static void main(String[] args) {
		Animal a1=new Animal();
		a1.setName("Oscar");
		a1.setAge(10);
		System.out.println(a1);
		a1.sleep();
		a1.eat();
//		Bird b1=new Bird();
//		b1.setName("Biscuit");
//		b1.setAge(5);
//		System.out.println(b1);
//		Bird b2=new Bird();
//		System.out.println(b2);
		Bird b3=new Bird("Sunny",3, true);
	}

}
