
public class Function5 extends Function{
	@Override
	public double fnValue(double x) {
		if (x==0.0) 
			return Double.MAX_VALUE;
		else 
			return Math.sin(1/x);
	}
	public String toString() {
		return "sin(1/x)";
	}
}
