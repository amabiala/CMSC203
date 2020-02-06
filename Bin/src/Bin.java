
public class Bin {
	private double height;
	private double width;
	double length;
	
	public Bin() {
		height=-1;
		width=-1;
		length=-1;
	}
	public Bin(double height, double width, double length) {
		this.height = height;
		this.width = width;
		this.length = length;
	}
	public Bin(Bin b) {
		this.height=b.height;
		this.length=b.length;
		this.width=b.width;
	}
	public Bin(double dimension) {
		height=dimension;
		width=dimension;
		length=dimension;
	}
}
