/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Group18.Eventbrite;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import junit.framework.TestCase;
import sd.HomePage;

/**
 *
 * @author Wei
 */
public class HomePageTest extends TestCase {

	public HomePageTest(String testName) {
		super(testName);
	}

	public void mainShouldTakeUserInput() {

		System.out.println("main(...) should take user input.");

		byte[] fakeInputBytes = new String("2").getBytes();
		InputStream fakeSystemIn = new ByteArrayInputStream(fakeInputBytes);
		InputStream realSystemIn = System.in;

		System.setIn(fakeSystemIn);
		HomePage.main(null);
		System.setIn(realSystemIn);

	}
}
