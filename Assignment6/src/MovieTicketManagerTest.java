import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MovieTicketManagerTest {
	private MovieTicketManager ticketList;
	

	@Before
	public void setUp() throws Exception {
		ticketList = new MovieTicketManager();
		
		//add tickets
		
		//add adults
        ticketList.addTicket("Avengers Endgame", "PG13", 2,20,"3D","Adult",0);  
        //add children
        ticketList.addTicket("Spies in disguise", "PG", 2,16,"3D","Child",0);
        //add employees
        ticketList.addTicket("The mummy", "NR", 7,20,"NONE","Employee",1234);
        ticketList.addTicket("Maleficent", "PG", 3,14,"3D","Employee",5678);       
        //add MoviePass members
        ticketList.addTicket("Aquaman", "PG13", 14,22,"NONE","MoviePass",1356);
        ticketList.addTicket("Thunderdogs", "G", 2,14,"3D","MoviePass",2785);
		
	}

	@After
	public void tearDown() throws Exception {
	  //set tickets to null 
	   //(tickets reference is their location in ticketList, emptying the list means
	   // leaving the objects for GC
	  ticketList.getAllTickets().clear();
	}

	/**
	 * Test the number of visits to the theater within the month
	 * This only applied to those who have id members - Employees or MoviePass members
	 */
	@Test
	public void testNumVisits() {
		//MoviePass
	  assertEquals(1,ticketList.numVisits(1356));
      ticketList.addTicket("AntMan", "PG13", 17,15,"NONE","MoviePass",1356);
      assertEquals(2,ticketList.numVisits(1356));
      ticketList.addTicket("The Losers", "PG13", 19,22,"3D","MoviePass",1356);
      assertEquals(3,ticketList.numVisits(1356));    
		
		//Employee members
      assertEquals(1,ticketList.numVisits(1234));
      ticketList.addTicket("Tolkien", "PG13", 6,13,"NONE","Employee",1234);
      assertEquals(2,ticketList.numVisits(1234));
      ticketList.addTicket("Doctor Sleep", "NR", 11,21,"IMAX","Employee",1234);
      assertEquals(3,ticketList.numVisits(1234));
		
	}

	/**
	 * Test the number of times this movie has been viewed
	 * This only applied to those who have id members - Employees or MoviePass members
	 */
	@Test
	public void testNumThisMovie() {
		//Employees
	  assertEquals(1,ticketList.numThisMovie(1234,"The mummy"));

		//MoviePass members
      assertEquals(1,ticketList.numThisMovie(1356,"Aquaman"));
	
	}

	/**
	 * Test the number of movies attended on a day
	 * This only applied to those who have id members - Employees or MoviePass members
	 */
	@Test
	public void testNumMoviesToday() {
		//Employees
	  assertEquals(1,ticketList.numMoviesToday(5678,3));

		//MoviePass members
      assertEquals(1,ticketList.numMoviesToday(2785,2));

	}

	/**
	 * Test adding tickets of the 4 types of tickets
	 */
	@Test
	public void testAddTicket() {
	  MovieTicketManager testList = new MovieTicketManager();
      //adult ticket
      assertEquals(17.54,testList.addTicket("6 underground", "PG13", 11,21,"3D","Adult",0),.01);
      //child ticket
      assertEquals(8.49,testList.addTicket("Frozen", "G", 5,13,"IMAX","Child",0),.01);
      //employee ticket - first movie this month
      assertEquals(0.00, testList.addTicket("It", "NR", 5,19,"NONE","Employee",4567),.01);
      //moviepass ticket - first movie this month
      assertEquals(9.99, testList.addTicket("Queen & Slim", "PG13", 3,13,"NONE","MoviePass",6753),.01);

      
	}

	/**
	 * Test the total of tickets sales for the month
	 */
	@Test
	public void testTotalSalesMonth() {
	  assertEquals(45.47,ticketList.totalSalesMonth(),.01);

	}

	/**
	 * The 3D tickets sold this month in chronological order by day
	 */
	@Test
	public void testGet3DTickets() {
	  ArrayList<String> result = ticketList.get3DTickets();
      assertTrue("Day 2",result.get(0).contains("Avengers Endgame"));
      assertTrue("Day 2",result.get(1).contains("Spies in disguise"));
      assertTrue("Day 2",result.get(2).contains("Thunderdogs"));
      assertTrue("Day 3",result.get(3).contains("Maleficent"));	
	}

	/**
	 * All tickets sold this month in chronological order by day
	 * You don't need to worry about ordering within the day
	 */
	@Test
	public void testGetAllTickets() {
	  ArrayList<String> result = ticketList.getAllTickets();
	  assertTrue("Day 2",result.get(0).contains("Day: 2"));
      assertTrue("Day 2",result.get(1).contains("Day: 2"));
      assertTrue("Day 2",result.get(2).contains("Day: 2"));
      assertTrue("Day 3",result.get(3).contains("Day: 3"));
      assertTrue("Day 7",result.get(4).contains("Day: 7"));
      assertTrue("Day 14",result.get(5).contains("Day: 14"));
	}

	/**
	 * The MoviePass tickets sold this month in order by MoviePass id
	 */
	@Test
	public void testGetMoviePassTickets() {
	  ArrayList<String> result = ticketList.getMoviePassTickets();
      assertTrue("1356",result.get(0).contains("1356"));
      assertTrue("2785",result.get(1).contains("2785"));
  
      ticketList.addTicket("Con Air", "PG13", 7,21,"3D","MoviePass",22222);
      ticketList.addTicket("The Mask", "PG13", 7,21,"3D","MoviePass",31415);
      result = ticketList.getMoviePassTickets();
      assertTrue("1356",result.get(0).contains("1356"));
      assertTrue("2785",result.get(1).contains("2785"));
      assertTrue("22222",result.get(2).contains("22222"));
      assertTrue("2785",result.get(3).contains("31415"));
      
	}

	/**
	 * The monthly sales report
	 */
	@Test
	public void testMonthlySalesReport(){
	  String result = ticketList.monthlySalesReport();
      Scanner scan = new Scanner(result);
      assertTrue(scan.nextLine().contains("Monthly Sales Report"));
      scan.nextLine();//blank line
      assertTrue(scan.nextLine().contains("Sales"));
      String line = scan.nextLine(); //Adult line
      assertTrue(line.contains("ADULT"));
      assertTrue(line.contains("17.54"));
      assertTrue(line.contains("1"));
      line = scan.nextLine(); //Child line
      assertTrue(line.contains("CHILD"));
      assertTrue(line.contains("7.95"));
      assertTrue(line.contains("1"));
      line = scan.nextLine(); //Employee line
      assertTrue(line.contains("EMPLOYEE"));
      assertTrue(line.contains("0.00"));
      assertTrue(line.contains("2"));
      line = scan.nextLine(); //Employee line
      assertTrue(line.contains("MOVIEPASS"));
      assertTrue(line.contains("19.98"));
      assertTrue(line.contains("2"));
	}
	
	/**
	 * Test readin from a file
	 * @throws FileNotFoundException when file is not found
	 */
	@Test
	public void testReadFile() throws FileNotFoundException {
	  PrintWriter testMovie = null;
      MovieTicketManager patrons;
      try {
          testMovie = new PrintWriter("ticketsFGV.txt"); 
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }
      testMovie.println("Avengers Endgame:PG13:2:20:3D:Adult:0");
      testMovie.println("Spies in disguise:PG:2:16:3D:Child:0");
      testMovie.println("The mummy:NR:7:20:NONE:Employee:1234");
      testMovie.println("Maleficent:PG:3:14:3D:Employee:5678");
      testMovie.println("Aquaman:PG13:14:22:NONE:MoviePass:1356");
      testMovie.println("Thunderdogs:G:2:14:3D:MoviePass:2785");
      testMovie.close();
      
      patrons = new MovieTicketManager();
      patrons.readFile(new File("ticketsFGV.txt"));
      ArrayList<String> result = patrons.getAllTickets();
	  
	  assertTrue("Day 2",result.get(0).contains("Day: 2"));
      assertTrue("Day 2",result.get(1).contains("Day: 2"));
      assertTrue("Day 2",result.get(2).contains("Day: 2"));
      assertTrue("Day 3",result.get(3).contains("Day: 3"));
      assertTrue("Day 7",result.get(4).contains("Day: 7"));
      assertTrue("Day 14",result.get(5).contains("Day: 14"));
	}

}
