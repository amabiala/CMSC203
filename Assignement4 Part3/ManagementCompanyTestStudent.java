

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestStudent {
	ManagementCompany mn;
	@Before
	public void setUp() throws Exception {
		//student create a management company
		mn= new ManagementCompany("CNCO","45612",2);
		//student add three properties, with plots, to mgmt co
		mn.addProperty("Pearson", "rockville", 500, "Chris", 2, 1, 1, 1);
		mn.addProperty("MDB", "Silver Spring", 6000, "Vic", 3, 2, 1, 1);
		mn.addProperty("Kerson", "Derwood", 4500, "David", 4, 3, 1, 1);
		
	}

	@After
	public void tearDown() {
		//student set mgmt co to null 
		mn=null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		
		//student should add property with 4 args & default plot (0,0,1,1)
		assertEquals(mn.addProperty("Hardman", "New York", 1000, "Bob",0,0,1,1),3,0);
		//student should add property with 8 args
		assertEquals(mn.addProperty("Riverdale", "Seattle", 3000, "Mike", 1, 4, 3, 3),4,0);		
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1
		assertEquals(mn.addProperty("PopShake", "Compton", 700, "Will", 3, 4, 3, 3),-1,0);
	}
 
	@Test
	public void testMaxPropertyRent() {
		System.out.print(mn.maxRentPropInfo());
		assertTrue(("Property Name: MDB\n" + 
				"  Located in: Silver Spring\n" + 
				"  Belonging to: Vic\n" + 
				"  Mortgage Amount: 6000.0").equals(mn.maxRentPropInfo()));
		
	}

	@Test
	public void testTotalRent() {
		assertEquals(mn.totalRent(),11000.0,0);
	}

 }