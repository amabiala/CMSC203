
public class Thing {
	private int x;
	private int y;
	private static int z=3;
	public Thing() {
		z*=2;
	}
	static void putThing(int a) {
		
		z=a;
	}
	public int getZ() {
		return z;
	}
}
