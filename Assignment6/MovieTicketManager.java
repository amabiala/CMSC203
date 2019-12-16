import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MovieTicketManager implements MovieTicketManagerInterface {
	private ArrayList<Ticket> ticketList=new ArrayList<Ticket>();
	private NumberFormat currencyFormat=NumberFormat.getCurrencyInstance();
	private DecimalFormat decimalFormat=new DecimalFormat("0.00");
	
	@Override
	public int numVisits(int id) {
		int count=0;
		for (int i=0;i<ticketList.size() && ticketList.get(i) !=null; i++) {
			if(ticketList.get(i).getId()==id) {
				count++;
			}
		}
		return count;
	}

	@Override
	public int numThisMovie(int id, String movie) {
		int count=0;
		for (int i=0;i<ticketList.size();i++) {
			if((ticketList.get(i).getId()==id)&&(ticketList.get(i).getName().equalsIgnoreCase(movie))) {
				count++;
			}
		}
		return count;
	}

	@Override
	public int numMoviesToday(int id, int date) {
		int count=0;
		for (int i=0;i<ticketList.size();i++) {
			if((ticketList.get(i).getId()==id)&&(ticketList.get(i).getDay()==date)) {
				count++;
			}
		}
		return count;
	}

	@Override
	public double addTicket(String movieN, String rating, int d, int t, String f, String type, int id) {
		double price=0;
		if(type.equalsIgnoreCase("child")) {
			Child child=new Child(movieN, rating, d, t, f, type, id);
			ticketList.add(child);
			price=child.calculateTicketPrice();
		}
		else if(type.equalsIgnoreCase("adult")) {
			Adult adult=new Adult(movieN, rating, d, t, f, type, id);
			ticketList.add(adult);
			price=adult.calculateTicketPrice();
		}
		else if(type.equalsIgnoreCase("employee")) {
			Employee employee=new Employee(movieN, rating, d, t, f, type, id);
			
			if(numVisits(id)<2) {
				price=0.0;
				employee.setNormalPrice(price);
			}
			else {
				price=employee.calculateTicketPrice();
			}
			ticketList.add(employee);
			
		}
		else {
			MoviePass moviePass=new MoviePass(movieN, rating, d, t, f, type, id);
			if((numVisits(id)<1)) {
				price=9.99;
				moviePass.setNormalPrice(price);
			}
			else if((numThisMovie(id, movieN)==0)&&(numVisits(id)>=1)){
				if((numMoviesToday(id,d)==0)&&(moviePass.getFormat()==Format.NONE)){
					price=0.0;
					moviePass.setNormalPrice(price);
			}
		}
			else {
				price=moviePass.calculateTicketPrice();
			}
			ticketList.add(moviePass);
		}
//		for (int i=0;i<ticketList.size();i++) {
//			if ((ticketList.get(i).getName().contentEquals(movieN))
//					&&(ticketList.get(i).getRating()==Rating.valueOf(rating))
//					&&(ticketList.get(i).getDay()==d)&&(ticketList.get(i).getTime()==t)
//					&&(ticketList.get(i).getFormat()==Format.valueOf(f))
//					&&(ticketList.get(i).getTicketType()==type)&&(ticketList.get(i).getId()==id)) {
//				 
//			}
//		}
		return price;
	}

	@Override
	public double totalSalesMonth() {
		double total=0;
		for(int i=0;i<ticketList.size();i++) {
			total+=ticketList.get(i).getNormalPrice();
		}
		return total;
	}

	@Override
	public String monthlySalesReport() {
	    int adultCount = 0, childCount = 0, employeeCount = 0, moviePassCount = 0;
	    double adultSales= 0, childSales = 0, employeeSales=0, moviePassSales=0;
	    for(int i = 0; i < ticketList.size(); i++) {
	        if(ticketList.get(i).getTicketType()==TicketType.ADULT) {
	        	adultSales += ticketList.get(i).calculateTicketPrice();
	            adultCount++;
	        }
	        else if(ticketList.get(i).getTicketType()==TicketType.CHILD) {
	            childSales += ticketList.get(i).calculateTicketPrice();
	            childCount++;
	        }
	        else if(ticketList.get(i).getTicketType()==TicketType.EMPLOYEE) {
	             employeeSales += ticketList.get(i).getNormalPrice();
	             employeeCount++;
	        }
	
	        else  if(ticketList.get(i).getTicketType()==TicketType.MOVIE_PASS) {
	             moviePassSales += ticketList.get(i).getNormalPrice();
	             moviePassCount++;
	               }
	   }
	
	   double totalSales1 = adultSales + childSales + employeeSales + moviePassSales;
	   return "\tMonthly Sales Report\n\n" 
	   + "\t\t\tSales\tNumber" 
	   + "\nADULT\t\t" + currencyFormat.format(adultSales) + "\t\t" + adultCount
	   + "\nCHILD\t\t" + currencyFormat.format(childSales) + "\t\t" + childCount
	   + "\nEMPLOYEE\t" + currencyFormat.format(employeeSales) + "\t\t" + employeeCount
	   + "\nMOVIEPASS\t" +currencyFormat.format(moviePassSales)  + "\t\t" + moviePassCount
	   + "\n\nTotal Monthly Sales " + currencyFormat.format(totalSales1) + "\n";
 }
	

	@Override
	public ArrayList<String> get3DTickets() {
		
		ArrayList<String> ticket3D=new ArrayList<String>();
		sortByDay();
		for (int i = 0; i < ticketList.size(); i++) {
			if((ticketList.get(i).getFormat()==Format.THREE_D)) {
				ticket3D.add(ticketList.get(i).toString());
			}
		}	
		return ticket3D;
		
	}
	

	@Override
	public ArrayList<String> getAllTickets() {
		ArrayList<String> allTickets=new ArrayList<String>();
		sortByDay();
		for (int i = 0; i < ticketList.size(); i++) {
			allTickets.add(ticketList.get(i).toString());
		}
		return allTickets;
	}

	@Override
	public ArrayList<String> getMoviePassTickets() {	
		ArrayList<String> ticketMoviePass=new ArrayList<String>();
		sortById();
		for (int i = 0; i < ticketList.size(); i++) {
			if((ticketList.get(i).getTicketType()==TicketType.MOVIE_PASS)) {
				ticketMoviePass.add(ticketList.get(i).toString());
			}
		}	 
		return ticketMoviePass;
	}
	@Override
	public void readFile(File file) throws FileNotFoundException {
		      Scanner sc = new Scanner(file);
		      String lineToRead, nameOfMovie, ratingOfMovie, featureOfMovie, theTypeOfMovie;
		      int movieDay, movieTime;
		      int ID = 0;
		      while(sc.hasNext()) {
		          lineToRead = sc.nextLine();
		          StringTokenizer strTokenizer = new StringTokenizer(lineToRead, ":");
		          nameOfMovie = strTokenizer.nextToken();
		          ratingOfMovie = strTokenizer.nextToken();
		          movieDay = Integer.parseInt(strTokenizer.nextToken());
		          movieTime = Integer.parseInt(strTokenizer.nextToken());
		          featureOfMovie = strTokenizer.nextToken();
		          theTypeOfMovie = strTokenizer.nextToken();
		          if(theTypeOfMovie.equalsIgnoreCase("MoviePass") || theTypeOfMovie.equalsIgnoreCase("Employee")) {
		              ID = Integer.parseInt(strTokenizer.nextToken());
		          }
		          addTicket(nameOfMovie, ratingOfMovie, movieDay, movieTime, featureOfMovie, theTypeOfMovie, ID);
		      }
		      sc.close();
		  }
		

	private void sortByDay() {
		Ticket temp;
		for (int i = 1; i < ticketList.size(); i++) {
			for (int j = i; j > 0; j--) {
				if ((ticketList.get(j).getDay()< ticketList.get(j-1).getDay())){
					temp = ticketList.get(j-1);
					ticketList.set(j-1, ticketList.get(j));
				      ticketList.set(j , temp);
		     }
		    }
		}
	}
	private void sortById() {
		Ticket temp;
		for (int i = 1; i < ticketList.size(); i++) {
			for (int j = i; j > 0; j--) {
				if ((ticketList.get(j).getId()< ticketList.get(j-1).getId())){
					temp = ticketList.get(j);
			      	ticketList.set(j, ticketList.get(j-1));
			      	ticketList.set(j-1, temp);
		     }
		    }
		}
	}

}
