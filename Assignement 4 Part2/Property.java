public class Property {

	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;

	public Property() {
		propertyName=" ";
		city=" ";
		rentAmount=0;
		owner=" ";
		plot=new Plot();
	}

	public Property(Property p) {
		propertyName=p.propertyName;
		city=p.city;
		rentAmount=p.rentAmount;
		owner=p.owner;
		plot=new Plot(p.plot);
	}

	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName=propertyName;
		this.city=city;
		this.rentAmount=rentAmount;
		this.owner=owner;
		plot=new Plot();
	}

	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName=propertyName;
		this.city=city;
		this.rentAmount=rentAmount;
		this.owner=owner;
		plot=new Plot(x,y,width,depth);
	}

	public void setPropertyName(String PropertyName) {
		this.propertyName=propertyName;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setCity(String city) {
		this.city=city;
	}

	public String getCity() {
		return city;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount=rentAmount;
	}

	public double getRentAmount() {
		return rentAmount;
	}

	public void setOwner(String owner) {
		this.owner=owner;
	}

	public String getOwner() {
		return owner;
	}

	public void setPlot(int x, int y, int width, int depth) {
		plot= new Plot(x,y,width,depth);
		
	}
	public Plot getPlot() {
		return plot;
	}

	public String toString() {
		return "Property Name: "+ getPropertyName()+"\n  Located in: "+getCity()+"\n  Belonging to: "+getOwner()+"\n  Mortgage Amount: "+getRentAmount();
	}

}