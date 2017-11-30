package Group18.Eventbrite;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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

		byte[] fakeInputBytes = "2\n".getBytes();
		InputStream fakeSystemIn = new ByteArrayInputStream(fakeInputBytes);
		InputStream realSystemIn = System.in;
		System.setIn(fakeSystemIn);

		try {
			HomePage.main(null);
		} catch (NoSuchElementException e) {
		}

		System.setIn(realSystemIn);

	}

	public void testWhetherMainCallsCorporateLoginPageWhenUserSelectsOption1() {

		System.out.println("main(...) should call corporateLoginPage() when the user selects option 1.");

		byte[] fakeInputBytes = "1\n".getBytes();
		InputStream fakeSystemIn = new ByteArrayInputStream(fakeInputBytes);
		InputStream realSystemIn = System.in;
		CLoginPage fakeCreateEvent = Mockito.mock(CLoginPage.class);
		System.setIn(fakeSystemIn);

		try {
			HomePage.main(null);
		} catch (NoSuchElementException e) {
		}

		System.setIn(realSystemIn);
		Mockito.verify(fakeCreateEvent, Mockito.times(0)).corporateLoginPage();

	}
}
