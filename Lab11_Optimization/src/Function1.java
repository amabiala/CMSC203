
public class Function1 extends Function {

	@Override
	public String answerString(double optVal, double x, double y, double z) {
		return "Minimum cost is "+optVal+" with height "+y+" and radius "+x;
	}

	@Override
	public double fnValue(double x) {
		double cost;
		if(x>0) {
		cost=0.8*Math.PI*Math.pow(x, 2)+(800/x);
		}
		else {
			return Double.MAX_VALUE;
		}
		return cost;
	}

	@Override
	public double getXVal(double x) {
		return x;
	}

	@Override
	public double getYVal(double x) {
		double y=2000/(Math.PI*Math.pow(x, 2));
		return y;
	}

	@Override
	public double getZVal(double x) {
		
		return -1.0;
	}
	public String toString() {
		return " Minimize the cost of a can that will hold 2 liters of liquid";
	}

}
