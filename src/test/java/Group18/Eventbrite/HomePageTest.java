package Group18.Eventbrite;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import junit.framework.TestCase;
import org.mockito.Mockito;
import sd.*;

public class HomePageTest extends TestCase {

	public HomePageTest(String testName) {
		super(testName);
	}

	public void testWhetherMainReadsUserInputFromSystemIn() {

		System.out.println("main(...) should read user input from System.in.");

		byte[] fakeInputBytes = "".getBytes();
		InputStream fakeSystemIn = new ByteArrayInputStream(fakeInputBytes);
		PrintStream fakeSystemOut = new PrintStream(new ByteArrayOutputStream());
		InputStream realSystemIn = System.in;
		PrintStream realSystemOut = System.out;

		System.setIn(fakeSystemIn);
		System.setOut(fakeSystemOut);

		boolean exceptionThrown = false;

		try {
			HomePage.main(null);
		} catch (NoSuchElementException e) {
			exceptionThrown = true;
		}

		System.setIn(realSystemIn);
		System.setOut(realSystemOut);

		if (!exceptionThrown) {
			fail("main(...) should have consumed an empty read buffer, and thrown a NoSuchElementException.");
		}

	}

	public void testWhetherMainCallsCorporateLoginPageWhenUserSelectsOption1() {

		System.out.println("main(...) should call corporateLoginPage() when the user selects option 1.");

		byte[] fakeInputBytes = "1\n1\n".getBytes();
		InputStream fakeSystemIn = new ByteArrayInputStream(fakeInputBytes);
		PrintStream fakeSystemOut = new PrintStream(new ByteArrayOutputStream());
		InputStream realSystemIn = System.in;
		PrintStream realSystemOut = System.out;

		System.setIn(fakeSystemIn);
		System.setOut(fakeSystemOut);

		CLoginPage fakeCorporateLoginPage = Mockito.mock(CLoginPage.class);

		try {
			HomePage.main(null);
		} catch (NoSuchElementException e) {
		}

		System.setIn(realSystemIn);
		System.setOut(realSystemOut);

		Mockito.verify(fakeCorporateLoginPage, Mockito.times(0)).corporateLoginPage();

	}
}
