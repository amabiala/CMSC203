
public class HeavyBin extends Bin{
	private double weight;

	public HeavyBin() {
		super();
		weight=-1;
	}

	public HeavyBin(HeavyBin b) {
		super(b);
		weight=b.weight;
	}

	public HeavyBin(double height, double width, double length, double weight) {
		super(height, width, length);
		this.weight=weight;
	}

	public HeavyBin(double dimension, double weight) {
		super(dimension);
		this.weight=weight;
	}
	
}
