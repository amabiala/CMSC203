
public class MoviePass extends Ticket{
	private final double BEFORE_SIX_PRICE=10.5;
	private final double AFTER_SIX_PRICE=13.5;
	private double imax;
	private double threeD;
	private double price;
	private int moviePassID;
	private double totalPrice;
	public MoviePass() {
		super();
		super.setTicketType("Moviepass");
	}

	public MoviePass(String movieName, String ticketType, double price, double imaxPrice, double threeDPrice, int id,
			int day, int time, Format format) {
		super(movieName, ticketType, price, imaxPrice, threeDPrice, id , day, time, format);
		super.setTicketType("Moviepass");
		moviePassID=id;
	}

	public MoviePass(String movieName, String ticketType, double price, double threeDPrice, int id, int day,
			int time, Format format) {
		super(movieName, ticketType, price, threeDPrice, id, day, time, format);
		super.setTicketType("Moviepass");
		moviePassID=id;
	}

	public MoviePass(String movieN, String rating, int d, int t, String f, String type, int id) {
		super(movieN, rating, d, t, f, type, id);
		super.setTicketType("Moviepass");
		moviePassID=id;
	}

	@Override
	public double calculateTicketPrice() {
		
		super.setThreeDPrice(2.5);
		threeD=super.getThreeDPrice();
		super.setImaxPrice(3.0);
		imax=super.getImaxPrice();
		if ((super.getTime()<18)) {
			price=BEFORE_SIX_PRICE;
		}
		if ((super.getTime()>=18)) {
			price=AFTER_SIX_PRICE;	
		}
		if ((super.getTime()<18)&&(super.getFormat()==Format.IMAX)) {
			price=BEFORE_SIX_PRICE+imax;	
		}
		if ((super.getTime()>=18)&&(super.getFormat()==Format.IMAX)) {
			price=AFTER_SIX_PRICE+imax;
		}
		if ((super.getTime()<18)&&(super.getFormat()==Format.THREE_D)) {
			price=BEFORE_SIX_PRICE+threeD;	
		}
		if ((super.getTime()>=18)&&(super.getFormat()==Format.THREE_D)) {
			price=AFTER_SIX_PRICE+threeD;	
		}
		totalPrice=price+(price*super.getTax());
		super.setNormalPrice(totalPrice);
		return totalPrice;
	}
	
	@Override
	public int getId() {
		return moviePassID;
	}

	@Override
	public String toString() {
		return "MOVIE PASS-"+getId() + super.toString();
	}
	

}
