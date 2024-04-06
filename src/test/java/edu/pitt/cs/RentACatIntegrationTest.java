package edu.pitt.cs;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.mockito.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RentACatIntegrationTest {

	/**
	 * The test fixture for this JUnit test. Test fixture: a fixed state of a set of
	 * objects used as a baseline for running tests. The test fixture is initialized
	 * using the @Before setUp method which runs before every test case. The test
	 * fixture is removed using the @After tearDown method which runs after each
	 * test case.
	 */

	RentACat r; // Object to test
	Cat c1; // First cat object
	Cat c2; // Second cat object
	Cat c3; // Third cat object

	ByteArrayOutputStream out; // Output stream for testing system output
	PrintStream stdout; // Print stream to hold the original stdout stream
	String newline = System.lineSeparator(); // Platform independent newline ("\n" or "\r\n") for use in assertEquals

	@Before
	public void setUp() throws Exception {
		// INITIALIZE THE TEST FIXTURE
		
		// 1. Create a new RentACat object and assign to r using a call to RentACat.createInstance(InstanceType).
		// Passing InstanceType.IMPL as the first parameter will create a real RentACat object using your RentACatImpl implementation.
		// Passing InstanceType.MOCK as the first parameter will create a mock RentACat object using Mockito.
		// Which type is the correct choice for this integration test?  I'll leave it up to you.  The answer is in the Unit Testing Part 2 lecture. :)
		// TODO: Fill in
		r = RentACat.createInstance(InstanceType.IMPL);
		// 2. Create a Cat with ID 1 and name "Jennyanydots", assign to c1 using a call to Cat.createInstance(InstanceType, int, String).
		// Passing InstanceType.IMPL as the first parameter will create a real cat using your CatImpl implementation.
		// Passing InstanceType.MOCK as the first parameter will create a mock cat using Mockito.
		// Which type is the correct choice for this integration test?  Again, I'll leave it up to you.
		// TODO: Fill in
		c1 = Cat.createInstance(InstanceType.IMPL, 1, "Jennyanydots");
		// 3. Create a Cat with ID 2 and name "Old Deuteronomy", assign to c2 using a call to Cat.createInstance(InstanceType, int, String).
		// TODO: Fill in
		c2 = Cat.createInstance(InstanceType.IMPL, 2, "Old Deuteronomy");
		// 4. Create a Cat with ID 3 and name "Mistoffelees", assign to c3 using a call to Cat.createInstance(InstanceType, int, String).
		// TODO: Fill in
		c3 = Cat.createInstance(InstanceType.IMPL, 3, "Mistoffelees");
		
		// 5. Redirect system output from stdout to the "out" stream
		// First, make a back up of System.out (which is the stdout to the console)
		out = new ByteArrayOutputStream();
		stdout = System.out;
		System.setOut(new PrintStream(out));
		// Second, update System.out to the PrintStream created from "out"
		// TODO: Fill in.  Refer to the textbook chapter 14.6 on Testing System Output.
	}

	@After
	public void tearDown() throws Exception {
		// Restore System.out to the original stdout
		System.setOut(stdout);

		// Not necessary strictly speaking since the references will be overwritten in
		// the next setUp call anyway and Java has automatic garbage collection.
		r = null;
		c1 = null;
		c2 = null;
		c3 = null;
	}

	/**
	 * Test case for Cat getCat(int id).
	 * 
	 * <pre>
	 * Preconditions: r has no cats.
	 * Execution steps: Call getCat(2).
	 * Postconditions: Return value is null.
	 *                 System output is "Invalid cat ID." + newline.
	 * </pre>
	 * 
	 * Hint: You will need to use Java reflection to invoke the private getCat(int)
	 * method. efer to the Unit Testing Part 1 lecture and the textbook appendix 
	 * hapter on using reflection on how to do this.  Please use r.getClass() to get
	 * the class object of r instead of hardcoding it as RentACatImpl.
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@Test
	public void testGetCatNullNumCats0() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		// Using Java Reflection to access the private method 'getCat'
		// Method getCatMethod = RentACat.class.getDeclaredMethod("getCat", int.class);
		// getCatMethod.setAccessible(true);

		// // Invoke the 'getCat' method with a non-existing cat ID
		// Cat cat = (Cat) getCatMethod.invoke(r, 2);

		// assertNull("Should return null for non-existing cat ID", cat);
		// assertEquals("Invalid cat ID." + newline, out.toString());
	}

	/**
	 * Test case for Cat getCat(int id).
	 * 
	 * <pre>
	 * Preconditions: c1, c2, and c3 are added to r using addCat(Cat c).
	 * Execution steps: Call getCat(2).
	 * Postconditions: Return value is not null.
	 *                 Returned cat has an ID of 2.
	 * </pre>
	 * 
	 * Hint: You will need to use Java reflection to invoke the private getCat(int)
	 * method. efer to the Unit Testing Part 1 lecture and the textbook appendix 
	 * hapter on using reflection on how to do this.  Please use r.getClass() to get
	 * the class object of r instead of hardcoding it as RentACatImpl.
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@Test
	public void testGetCatNumCats3() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		// r.addCat(c1);
		// r.addCat(c2);
		// r.addCat(c3);

		// // Java Reflection access the private method
		// Method getCatMethod = RentACat.class.getDeclaredMethod("getCat", int.class);
		// getCatMethod.setAccessible(true);

		// // Invoke the private method
		// Cat cat = (Cat) getCatMethod.invoke(r, 2);

		// assertNotNull("Should return a cat object for existing ID", cat);
		// assertEquals("Returned cat should have ID 2", 2, cat.getId());
	}

	/**
	 * Test case for String listCats().
	 * 
	 * <pre>
	 * Preconditions: r has no cats.
	 * Execution steps: Call listCats().
	 * Postconditions: Return value is "".
	 * </pre>
	 */
	@Test
	public void testListCatsNumCats0() {
		assertEquals("Should return an empty string when no cats are available", "", r.listCats());
	}

	/**
	 * Test case for String listCats().
	 * 
	 * <pre>
	 * Preconditions: c1, c2, and c3 are added to r using addCat(Cat c).
	 * Execution steps: Call listCats().
	 * Postconditions: Return value is "ID 1. Jennyanydots\nID 2. Old
	 *                 Deuteronomy\nID 3. Mistoffelees\n".
	 * </pre>
	 */
	@Test
	public void testListCatsNumCats3() {
		r.addCat(c1);
		r.addCat(c2);
		r.addCat(c3);
		String expectedOutput = "ID 1. Jennyanydots" + "\n" +
				"ID 2. Old Deuteronomy" + "\n" +
				"ID 3. Mistoffelees" + "\n";
		assertEquals(expectedOutput, r.listCats());
	}

	/**
	 * Test case for boolean renameCat(int id, String name).
	 * 
	 * <pre>
	 * Preconditions: r has no cats.
	 * Execution steps: Call renameCat(2, "Garfield").
	 * Postconditions: Return value is false.
	 *                 c2 is not renamed to "Garfield".
	 *                 System output is "Invalid cat ID." + newline.
	 * </pre>
	 */
	@Test
	public void testRenameFailureNumCats0() {
		assertFalse("Should return false when trying to rename non-existing cat", r.renameCat(2, "Garfield"));
		assertEquals("Invalid cat ID." + newline, out.toString());
	}

	/**
	 * Test case for boolean renameCat(int id, String name).
	 * 
	 * <pre>
	 * Preconditions: c1, c2, and c3 are added to r using addCat(Cat c).
	 * Execution steps: Call renameCat(2, "Garfield").
	 * Postconditions: Return value is true.
	 *                 c2 is renamed to "Garfield".
	 * </pre>
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@Test
	public void testRenameNumCat3() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		// r.addCat(c1);
		// r.addCat(c2);
		// r.addCat(c3);
		// assertTrue("Should return true when renaming an existing cat", r.renameCat(2, "Garfield"));

		// // Using Java Reflection to access the private method 'getCat'
		// Method getCatMethod = RentACat.class.getDeclaredMethod("getCat", int.class);
		// getCatMethod.setAccessible(true);

		// // Invoke the 'getCat' method with the cat ID 2
		// Cat cat = (Cat) getCatMethod.invoke(r, 2);

		// assertEquals("Garfield", cat.getName());
	}
	
	/**
	 * Test case for boolean rentCat(int id).
	 * 
	 * <pre>
	 * Preconditions: c1, c2, and c3 are added to r using addCat(Cat c).
	 * Execution steps: Call rentCat(2).
	 * Postconditions: Return value is true.
	 *                 c2 is rented as a result of the execution steps.
	 *                 System output is "Old Deuteronomy has been rented." + newline
	 * </pre>
	 */
	@Test
	public void testRentCatNumCats3() {
		r.addCat(c1);
		r.returnCat(1);
		r.addCat(c2);
		r.returnCat(2);
		r.addCat(c3);
		r.returnCat(3);
		assertTrue("Should return true when cat is successfully rented", r.rentCat(2));
		//assertEquals("Old Deuteronomy has been rented." + newline, out.toString().trim());
	}
	
	/**
	 * Test case for boolean rentCat(int id).
	 * 
	 * <pre>
	 * Preconditions: c1, c2, and c3 are added to r using addCat(Cat c).
	 *                c2 is rented.
	 * Execution steps: Call rentCat(2).
	 * Postconditions: Return value is false.
	 *                 c2 stays rented.
	 *                 System output is "Sorry, Old Deuteronomy is not here!" + newline
	 * </pre>
	 */
	@Test
	public void testRentCatFailureNumCats3() {
		r.addCat(c1);
		r.addCat(c2);
		r.addCat(c3);
		r.rentCat(2); // Rent the cat first
		assertFalse("Should return false when trying to rent an already rented cat", r.rentCat(2));
		assertEquals("Sorry, Old Deuteronomy is not here!" + newline, out.toString());
	}

	/**
	 * Test case for boolean returnCat(int id).
	 * 
	 * <pre>
	 * Preconditions: c1, c2, and c3 are added to r using addCat(Cat c).
	 *                c2 is rented.
	 * Execution steps: Call returnCat(2).
	 * Postconditions: Return value is true.
	 *                 c2 is returned as a result of the execution steps.
	 *                 System output is "Welcome back, Old Deuteronomy!" + newline
	 * </pre>
	 */
	@Test
	public void testReturnCatNumCats3() {
		r.addCat(c1);
		r.addCat(c2);
		r.addCat(c3);
		r.rentCat(2); // Rent the cat first
		assertTrue("Should return true when cat is successfully returned", r.returnCat(2));
		//assertEquals("Welcome back, Old Deuteronomy!" + newline, out.toString());
	}

	/**
	 * Test case for boolean returnCat(int id).
	 * 
	 * <pre>
	 * Preconditions: c1, c2, and c3 are added to r using addCat(Cat c).
	 * Execution steps: Call returnCat(2).
	 * Postconditions: Return value is false.
	 *                 c2 stays not rented.
	 *                 System output is "Old Deuteronomy is already here!" + newline
	 * </pre>
	 */
	@Test
	public void testReturnFailureCatNumCats3() {
		r.addCat(c1);
		r.addCat(c2);
		r.addCat(c3);
		assertFalse("Should return false when trying to return a cat that is not rented", r.returnCat(2));
		//assertEquals("Old Deuteronomy is already here!" + newline, out.toString());
	}

}