
public class ThingDemo {

	public static void main(String[] args) {
		Thing one=new Thing();
		Thing two=new Thing();
		Thing three=new Thing();
		
		System.out.println(one.getZ());
		Thing.putThing(12);
		System.out.println(one.getZ());
		System.out.println(two.getZ());
		
	}

}
