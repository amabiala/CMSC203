public class Circle extends Shape implements ShapeOperation {
	private double radius;
	public Circle (String name,String color, double radius) {
		super(name, color);
		this.radius=radius;
	}
	public Circle(Circle c) {
		super(c);
		radius =c.radius;
	}
	@Override
	public double calcArea() {
		return Math.PI*Math.pow(radius, 2);
	}
	@Override
	public String toString() {
		return "Circle:" +"\n"+ super.toString()+"\nRadius:" +radius+"\nArea "+calcArea() ;
	}
	@Override
	public String rotate(int degree) {
		// TODO Auto-generated method stub
		return super.toString()+" rotated "+degree;
	}
	@Override
	public String moveRight() {
		return super.toString()+ "  moved right";
	}
	@Override
	public boolean equals(Object o) {
		Circle s=(Circle) o;
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