
public class Function3 extends Function{

	@Override
	public String answerString(double optVal, double x, double y, double z) {
		return "The closest point is: "+optVal+" with x: "+x+" and y: "+y;
	}    

	@Override
	public double fnValue(double x) {
		return (Math.sqrt((Math.pow(x, 4.0))-(Math.pow(x, 2.0))+1));
	}

	@Override
	public double getXVal(double x) {
		return x;
	}

	@Override
	public double getYVal(double x) {
		
		return (Math.pow(x, 2.0));
	}

	@Override
	public double getZVal(double x) {
		
		return -1.0;
	}
	public String toString() {
		return " Find the closest point on a parabola to a given point";
	}

}
