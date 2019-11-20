import java.util.ArrayList;

public class AnimalDemo {

	public static void main(String[] args) {
		ArrayList<Animal> b= new ArrayList<Animal>();
		Bird b1=new Bird("Penguin", 10, false);
		Bird b2=new Bird("Parraket", 5, true);
		b.add(new Animal());
		b.add(b1);
		b.add(b2);
		for(Animal c:b) {
			
			System.out.println(c);
			System.out.println(c.eat());
			if (c instanceof Bird) {
				System.out.println(((Bird)c).fly());
			}
			System.out.println();
			
		}

	}

}
