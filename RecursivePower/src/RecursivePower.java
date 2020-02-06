
public class RecursivePower {
	public static int power(int x,int y) {
		int result;
		if(y==0) {
			result= 1;
		}
		else {
			result= x* power(x,y-1);
		}
		return result;
	}
}
