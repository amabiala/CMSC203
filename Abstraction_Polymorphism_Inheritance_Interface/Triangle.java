
public class Triangle extends Shape implements ShapeOperation {
	private double base;
	private double height;
	
	public Triangle() {
		super();
	}
	public Triangle(String name, String color, double height, double base) {
		super(name, color);
		this.base= base;
		this.height=height;
	}
	public Triangle (Triangle t) {
		super(t);
		base= t.base;
		height=t.height;
	}
	@Override
	public double calcArea() {
		return ((base*height)/2);
	}
	@Override
	public String toString() {
		return "Triangle: \n"+ super.toString()+"\nBase: "+base+"\nHeight: "+height+"\nArea: "+calcArea();
	}
	@Override
	public String rotate(int degree) {
		// TODO Auto-generated method stub
		return super.toString()+" rotated "+degree;
	}
	@Override
	public String moveRight() {
		// TODO Auto-generated method stub
		return super.toString()+ "  moved right";
	}
	@Override
	public boolean equals(Object o) {
		Triangle s=(Triangle) o;
		boolean equal=false;
		if (name.equals(s.name) &&(color.equals(s.color))) {
			equal=true;
		}
		else {
			equal=false;
		}
		return equal;
	}
}
