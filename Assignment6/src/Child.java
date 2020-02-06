
public class Child extends Ticket{

	private final double BEFORE_SIX_PRICE=5.75;
	private final double AFTER_SIX_PRICE=10.75;
	private double imax;
	private double threeD;
	private double price;
	private double totalPrice;
	public Child() {
		super();
		super.setTicketType("Child");
		
	}

	public Child(String movieName, String ticketType, double price, double imaxPrice, double threeDPrice, int id, int day, int time,
			Format format) {
		super(movieName, ticketType, price, imaxPrice, threeDPrice, id, day, time, format);
		super.setTicketType("Child");
	}

	public Child(String movieName, String ticketType, double price, double threeDPrice, int id, int day, int time, Format format) {
		super(movieName, ticketType, price, threeDPrice, id, day, time, format);
		super.setTicketType("Child");
	}
	

	public Child(String movieN, String rating, int d, int t, String f, String type, int id) {
		super(movieN, rating, d, t, f, type, id);
		super.setTicketType("Child");
	}

	@Override
	public double calculateTicketPrice() {
		
		super.setThreeDPrice(1.5);
		threeD=super.getThreeDPrice();
		super.setImaxPrice(2.0);
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
		return -1;
	}

	@Override
	public String toString() {
		return "CHILD " + super.toString();
	}

}
