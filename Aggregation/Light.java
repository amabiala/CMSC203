
public class Light {
	private String brand;
	private int voltage;
	
	public Light() {
		this("no brand", 0);
	}
	public Light(String br, int volt) {
		brand=br;
		voltage=volt;
	}
	public String toString() {
		return "Brand: "+ brand+"\n"+"Voltage: "+voltage;
	}
}
