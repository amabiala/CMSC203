
public class Car {
	private String name;
	private Light light;
	
	public Car(Light light, String name){
		this.name=name;
		this.light=light;
	}
	public Car (String name, String brand, int volt){
		this.name=name;
		this.light=new Light(brand,volt);
		
	}
	
	public String toString() {
		return "Name: "+ name+"\n"+"Light: "+light;
	}
}
