import java.util.Scanner;
public class TicketDriver {

	public static void main(String[] args) {
		
		String name, ticketType;
		int ticketNum, speed, speedLimit;
		boolean workZone,schoolZone;
		char response; 
		double fine;
		Ticket ticket=new Ticket();
		
		Scanner key=new Scanner(System.in);
		System.out.println("Ticket Manager: Creates ticket\n");
		
		System.out.println("Please enter the first and last name of the violator: ");
		name=key.nextLine();
		ticket.setName(name);
		
		System.out.println("Please enter the speed of the violator(>0): ");
		speed=key.nextInt();
		ticket.setSpeed(speed);
		while(speed<0) {
			System.out.println("Please enter the speed of the violator(>0): ");
			speed=key.nextInt();
		}
		
		System.out.println("Please enter the speed limit in this zone(>0,<=80): ");
		speedLimit=key.nextInt();
		ticket.setSpeedLimit(speedLimit);
		while(speedLimit<0||speedLimit>80) {
			System.out.println("Please enter the speed limit in this zone(>0,<=80): ");
			speedLimit=key.nextInt();
		}
		
		key.nextLine();
		
		System.out.println("Was this a school zone?(Y/N): ");
		response= key.next().charAt(0);
		schoolZone=ticket.isSchoolZone(response);
		ticket.setSchoolZone(schoolZone);
		
		System.out.println("Was this a work zone?(Y/N): ");
		response= key.next().charAt(0);	
		workZone=ticket.isWorkZone(response);
		ticket.setWorkZone(workZone);
		
		fine=ticket.calculateFine();
		System.out.println(" ");
		
		System.out.println(ticket.toString()+"\n\n");
		System.out.println(ticket.printNotice()+"\n\n");
		
		System.out.println("Would you like to enter another ticket?(Y/N): ");
		response=key.next().charAt(0);
		if (response=='N'||response=='n'){
			System.out.println("Exiting Ticket Manager!");
			
		}
		
		while (response=='Y'||response =='y') {
			key.nextLine();
			System.out.println("Please enter the first and last name of the violator: ");
			name=key.nextLine();
			ticket.setName(name);
			
			System.out.println("Please enter the speed of the violator(>0): ");
			speed=key.nextInt();
			ticket.setSpeed(speed);
			while(speed<0) {
				System.out.println("Please enter the speed of the violator(>0): ");
				speed=key.nextInt();
			}
			
			System.out.println("Please enter the speed limit in this zone(>0,<=80): ");
			speedLimit=key.nextInt();
			ticket.setSpeedLimit(speedLimit);
			while(speedLimit<0||speedLimit>80) {
				System.out.println("Please enter the speed limit in this zone(>0,<=80): ");
				speedLimit=key.nextInt();
			}
			
			key.nextLine();
			System.out.println("Was this a school zone?(Y/N): ");
			response= key.next().charAt(0);
			schoolZone=ticket.isSchoolZone(response);
			ticket.setSchoolZone(schoolZone);
			
			System.out.println("Was this a work zone?(Y/N): ");
			response= key.next().charAt(0);	
			workZone=ticket.isWorkZone(response);
			ticket.setWorkZone(workZone);
			
			fine=ticket.calculateFine();
			System.out.println(" ");
			
			System.out.println(ticket.toString()+"\n\n");
			System.out.println(ticket.printNotice()+"\n\n");
			
			System.out.println("Would you like to enter another ticket?(Y/N): ");
			response=key.next().charAt(0);
		
			
			}
		
		
		}
	

}
