
public abstract class Ticket {
	private String movieName;
	private TicketType ticketType;
	private final double TAX=0.096;
	private double price;
	private double imaxPrice;
	private double ThreeDPrice;
	private int Id;
	private int day;
	private Format format;
	private Rating rating;
	private int time;
	
	
	public Ticket() {
		movieName=" ";
		price=0.0;
		imaxPrice=0.0;
		ThreeDPrice=0.0;
		Id=0;
		day=1;
		format=Format.NONE;
		time=8;
		
	}
	public Ticket(String movieName, String ticketType, double price, double imaxPrice, double threeDPrice, int id, int day,int time, Format format) {
		this.movieName = movieName;
		if(ticketType.equalsIgnoreCase("adult")) {
			this.ticketType=TicketType.ADULT;
		}
		else if (ticketType.equalsIgnoreCase("child")) {
			this.ticketType=TicketType.CHILD;
		}
		else if (ticketType.equalsIgnoreCase("employee")) {
			this.ticketType=TicketType.EMPLOYEE;
		}
		else {
			this.ticketType=TicketType.MOVIE_PASS;
		}
		this.price = price;
		this.imaxPrice = imaxPrice;
		ThreeDPrice = threeDPrice;
		this.Id = id;
		this.day = day;
		this.time = time;
		this.format=format;
	}
	public Ticket(String movieName, String ticketType, double price, double threeDPrice, int id, int day, int time, Format format) {
		this.movieName = movieName;
		if(ticketType.equalsIgnoreCase("adult")) {
			this.ticketType=TicketType.ADULT;
		}
		else if (ticketType.equalsIgnoreCase("child")) {
			this.ticketType=TicketType.CHILD;
		}
		else if (ticketType.equalsIgnoreCase("employee")) {
			this.ticketType=TicketType.EMPLOYEE;
		}
		else {
			this.ticketType=TicketType.MOVIE_PASS;
		}
		this.price = price;
		ThreeDPrice = threeDPrice;
		this.Id = id;
		this.day = day;
		this.time = time;
		this.format=format;
	}
	public Ticket(String movieN, String rating, int d, int t, String f, String type, int id) {
		movieName=movieN;
		this.rating=Rating.valueOf(rating);
		day=d;
		time=t;
		if(f.equalsIgnoreCase("3D")) {
			format=Format.THREE_D;
		}
		else if(f.equalsIgnoreCase("imax")) {
			format=Format.IMAX;
		}
		else {
			format=Format.NONE;
		}
		if(type.equalsIgnoreCase("adult")) {
			this.ticketType=TicketType.ADULT;
		}
		else if (type.equalsIgnoreCase("child")) {
			this.ticketType=TicketType.CHILD;
		}
		else if (type.equalsIgnoreCase("employee")) {
			this.ticketType=TicketType.EMPLOYEE;
		}
		else {
			this.ticketType=TicketType.MOVIE_PASS;
		}
		this.Id=id;
	}
	public double getTax() {
		return TAX;
	}
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getName() {
		return movieName;
	}
	public void setName(String name) {
		this.movieName = name;
	}
	public double getNormalPrice() {
		return price;
	}
	public void setNormalPrice(double normalPrice) {
		this.price = normalPrice;
	}
	
	public double getImaxPrice() {
		return imaxPrice;
	}
	public void setImaxPrice(double imaxPrice) {
		this.imaxPrice = imaxPrice;
	}
	public double getThreeDPrice() {
		return ThreeDPrice;
	}
	public void setThreeDPrice(double threeDPrice) {
		ThreeDPrice = threeDPrice;
	}
	public Format getFormat() {
		return format;
	}
	public void setFormat(Format format) {
		this.format = format;
	}
	public void setId(int id) {
		Id = id;
	}
	public TicketType getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		if(ticketType.equalsIgnoreCase("adult")) {
			this.ticketType=TicketType.ADULT;
		}
		else if (ticketType.equalsIgnoreCase("child")) {
			this.ticketType=TicketType.CHILD;
		}
		else if (ticketType.equalsIgnoreCase("employee")) {
			this.ticketType=TicketType.EMPLOYEE;
		}
		else {
			this.ticketType=TicketType.MOVIE_PASS;
		}
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	public abstract double calculateTicketPrice();
	public abstract int getId();

	@Override
	public String toString() {
		return " Movie name: " + movieName + " Rating: "+ rating + " Day: " + day+ " Time: " + time+" Price: " + price;
	}
	
	
}
