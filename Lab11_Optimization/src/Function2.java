
public class Function2 extends Function{
	@Override
	public String answerString(double optVal, double x, double y, double z) {
		return "Minimum distance is "+optVal+" with AB distance: "+x+" and BD distance: "+y+ "with the BC Distance: "+z;
	}	

	@Override
	public double fnValue(double x) {
        if (x >= 0 && x <= 4)
            return (x / 3) + 2 * (Math.sqrt((Math.pow(x, 2)) - 8 * x + 25));
        else
            return Double.MAX_VALUE;
	}

	@Override
	public double getXVal(double x) {
		return x;
	}

	@Override
	public double getYVal(double x) {
		return (4-x);
	}

	@Override
	public double getZVal(double x) {
		double z=Math.sqrt(Math.pow(3.0, 2)+(Math.pow((4-x),2.0)));
		return z;
	}
	public String toString() {
		return " Find the minimum distance a dog can run and swim to fetch the ball";
	}
}
