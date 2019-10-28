
public class CarDemo {

	public static void main(String[] args) {
		Light L=new Light("XYZ", 100);
		Car a=new Car(L, "BMW");
		System.out.println(a+"\n");
		Car b=new Car("Honda", "WXZ",20);
		System.out.println(b);

	}

}
