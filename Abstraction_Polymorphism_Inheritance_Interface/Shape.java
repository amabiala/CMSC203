
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
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract double calcArea();
	
	@Override
	public  boolean equals(Object o) {
		if(o instanceof Shape) {
			Shape temp=(Shape) o;
			return (temp.color.equals(this.color)&&(temp.name.equals(this.name)));
		}
		return false;
	}
	
	public String toString() {
		return "Name: "+name+"\nColor: "+color;
	}
	
}
