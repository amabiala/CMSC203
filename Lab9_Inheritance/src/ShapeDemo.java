import java.util.ArrayList;

public class ShapeDemo {

	public static void main(String[] args) {
		ArrayList<Shape> shape=new ArrayList<Shape>();
		Circle largPizza=new Circle("Pizza","Yellow",10);
		Circle largePizza=new Circle(largPizza);
		Triangle pizzaSlice=new Triangle ("Slice","Yellow",5,2);
		shape.add(largPizza);
		shape.add(largePizza);
		shape.add(pizzaSlice);
		for(Shape a: shape) {
			System.out.println(a.toString()+" ");
			System.out.println();
		}

	}

}