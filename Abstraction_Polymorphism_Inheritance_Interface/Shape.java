
public abstract class Shape {
	protected String color;
	protected String name;
	
	public Shape() {
		color = "Gray";
		name = "SomeName";
	}

	public Shape(String color, String name) {
		this.color = color;
		this.name = name;
	}
	public Shape(Shape s) {
		color = s.color;
		name = s.name;
	}
	public abstract double calcArea();
	
	@Override
	public abstract boolean equals(Object o) ;
	
	public String toString() {
		return "Name: "+name+"\nColor: "+color;
	}
	
}
