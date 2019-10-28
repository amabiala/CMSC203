import java.lang.Math;
/**
 * 
 * @author sumutoni
 *
 */
public class Ticket {
	private String ticketType, name;
	private int ticketNum, speed, speedLimit;
	private boolean workZone,schoolZone;
	/**
	 * creates a Ticket object 
	 */
	public Ticket() {
		this.name=name;
		this.speed=speed;
		this.speedLimit=speedLimit;
	}
	
	/**
	 * creates a Ticket object with given name, speed, speed Limit, school zone and work zone
	 * @param name name of violator
	 * @param speed speed of violator
	 * @param speedLimit speed limit of the zone
	 * @param schoolZone whether it was a school zone or not
	 * @param workZone whether it was a work zone or not
	 */
	public Ticket (String name, int speed, int speedLimit, boolean schoolZone, boolean workZone) {
		this.name=name;
		this.speed=speed;
		this.speedLimit=speedLimit;
		this.schoolZone=schoolZone;
		this.workZone=workZone;
	}
	
	/**
	 * creates a ticket object with given name, speed and speed limit
	 * @param name name of violator
	 * @param speed speed of violator
	 * @param speedLimit speed limit of the zone
	 */
	public Ticket(String name, int speed, int speedLimit) {
		this.name=name;
		this.speed=speed;
		this.speedLimit=speedLimit;
		this.workZone=false;
		this.schoolZone=false;
	}
	
	/**
	 * setter method to set name of violator
	 * @param name name of violator
	 */
	public void setName(String name) {
		this.name=name;
	}
	
	/**
	 * getter method to get name of violator
	 * @return name of violator
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * setter method to set speed of violator
	 * @param speed speed of violator
	 */
	public void setSpeed(int speed) {
		this.speed=speed;
	}
	/**
	 * getter method to get speed of violator
	 * @return speed of violator
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * setter method to set speed limit of zone
	 * @param speedLimit speed limit of zone
	 */
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit=speedLimit;
	}
	
	/**
	 * getter method to set speed limit of zone
	 * @return speed limit of zone
	 */
	public int getSpeedLimit() {
		return speedLimit;
	}
	
	/**
	 * set to school zone if violator was in school zone
	 * @param schoolZone if violator was in school zone
	 */
	public void setSchoolZone(boolean schoolZone) {
		this.schoolZone=schoolZone;
	}
	
	/**
	 * checks if violator was in school zone
	 * @param res response of ticket manager to validate if it was or not a school zone
	 * @return true if school zone and false otherwise
	 */
	public boolean isSchoolZone(char res) {
		 
		if(res=='y'||res=='Y') {
			schoolZone=true;	
		
	}
		else {
			schoolZone=false;
		}
		return schoolZone;
	}
	
	/**
	 * checks if violator was in work zone
	 * @param res response of ticket manager to validate if it was or not a work zone
	 * @return true if work zone and false otherwise
	 */
	public boolean isWorkZone(char res) {
		
		if(res=='y'||res=='Y') {
			workZone=true;
	}
		else {
			workZone=false;
		}
		return workZone;
	}
	
	/**
	 * set to school zone if violator was in work zone
	 * @param workZone if violator was in work zone
	 */
	public void setWorkZone(boolean workZone) {
		this.workZone=workZone;
	}
	
	/**
	 * Calculate the fine based on the following: 
	   1 - 10 MPH over limit - $140 minimum
	   school zone - $200
	   work zone - $250 or both
	   11 - 20 MPH over limit - $195 minimum
	   school zone - $300
	   work zone - $350 or both
	   21 - 30 MPH over limit - $450
	   31 - 40 MPH over limit - $495, must appear personally
	   41 MPH and up - $600, must appear personally
	 * @return the speeding fine
	 */
	public double calculateFine() {
		int speedOverLimit;
		double fine=0;
		speedOverLimit= this.speed-this.speedLimit;
		if ((speedOverLimit>=1 && speedOverLimit<=10) && (schoolZone==false) && (workZone==false)) {
			fine =140;
		}
		else if (((speedOverLimit>=1 && speedOverLimit<=10) && workZone==true && schoolZone==true)||(speedOverLimit>=1 && speedOverLimit<=10) && workZone==true) {
			fine=250;
		}
		else if ((speedOverLimit>=1 && speedOverLimit<=10) && schoolZone==true) {
			fine=200;
		}
		
		if ((speedOverLimit>=11 && speedOverLimit<=20) && (schoolZone==false) && (workZone==false)) {
			fine =195;
		}
		else if (((speedOverLimit>=11 && speedOverLimit<=20) && workZone==true && schoolZone==true)||(speedOverLimit>=11 && speedOverLimit<=20) && workZone==true) {
			fine=350;
		}
		
		else if ((speedOverLimit>=11 && speedOverLimit<=20) && schoolZone==true) {
			fine=300;
		}
		
		else if ((speedOverLimit>=21 && speedOverLimit<=30)) {
			fine=450;
		}
		
		
		else if ((speedOverLimit>=31 && speedOverLimit<=40)) {
			fine=495;
		}
		
		
		else if ((speedOverLimit>=41)) {
			fine=600;
		}
		
		return fine;
	}
	
	/**
	 * generates random number for ticket between given limit
	 * @param min the lowest limit is 100000
	 * @param max the highest limit is 999999
	 * @return the number that was generated for the ticket
	 */
	private int generateTicketNum(double min, double max) {
		
		double num= (Math.random()*((max-min)+1))+min;
		return (int)num;
	}
	
	/**
	 * generates random number for court date between given limit
	 * @param min the lowest limit is 1
	 * @param max the highest limit is 31
	 * @return the day generated for court date
	 */
	private int generateCourtDate(double min, double max) {
		
		double day= (Math.random()*((max-min)+1))+min;
		return (int)day;
	}
	
	/**
	 * determines if the ticket is "PAYABLE" or "MUST APPEAR"
	 * @return ticket type
	 */
	public String determineTicketType() {
		int speedOverLimit;
		speedOverLimit= this.speed-this.speedLimit;
		if (speedOverLimit>=31) {
			this.ticketType="MUST APPEAR";
		}
		else
			this.ticketType="PAYABLE";
		
		return ticketType;
	}
	/**
	 * prints a notice to send to the violator
	 * @return notice to send to the violator
	 */
	public String printNotice() {
		String output;
		determineTicketType();
		if (ticketType.equals("MUST APPEAR")) {
			output="Department of Motor Vehicles\nAutomated Traffic Enforcement\n\n\nDear "+getName()+",\n\nPlease pay the following speeding fine of "+calculateFine()+" $ to the DMV within 10 days of\nreceiving this notice to avoid a driver's license suspension. You are being fined for going "+getSpeed()+" MPH in a "+getSpeedLimit()+" MPH zone.\n\nTicket Type: "+ticketType+"\nYou must appear at the County Court House on October "+generateCourtDate(1,31)+", 2019."+"\nTicket Number: "+generateTicketNum(100000,999999)+"\n\nReturned checks are subject to a returned check fee of 35.00$.\n\nSincerely,\nStephanie UMUTONI";
		}
		else {
			output="Department of Motor Vehicles\nAutomated Traffic Enforcement\n\n\nDear "+getName()+",\n\nPlease pay the following speeding fine of "+calculateFine()+" $ to the DMV within 10 days of\nreceiving this notice to avoid a driver's license suspension. You are being fined for going "+getSpeed()+" MPH in a "+getSpeedLimit()+" MPH zone.\n\nTicket Type: "+ticketType+"\nTicket Number: "+generateTicketNum(100000,999999)+"\n\nReturned checks are subject to a returned check fee of 35.00$.\n\nSincerely,\nStephanie UMUTONI";
		}
		return output;
	}
	
	/**
	 * String representation of the ticket object
	 */
	public String toString () {
		String output;
		output="Name of Violator: "+getName()+"\nSpeed of the violator: "+getSpeed()+" MPH\nSpeed limit:"+getSpeedLimit()+" MPH\nSchool Zone: "+schoolZone+"\nWork Zone: "+workZone+"\nFine: "+calculateFine()+"$";
		return output;
	}
}
