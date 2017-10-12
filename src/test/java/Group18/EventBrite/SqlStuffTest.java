package Group18.EventBrite;

import java.sql.ResultSet;
import java.sql.SQLException;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author Wei
 */
public class SqlStuffTest extends TestCase {

	public SqlStuffTest(String testName) {
		super(testName);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testWhetherTryToConnectThrowsClassNotFoundException() throws ClassNotFoundException {

		System.out.println("tryToConnect() should not throw a ClassNotFoundException");

		SqlStuff.tryToConnect();

	}

	@Test
	public void testWhetherTryToConnectThrowsSQLException() throws SQLException {

		System.out.println("tryToConnect() should not throw an SQLException");

		SqlStuff.tryToConnect();

	}

	@Test
	public void testWhetherTryToConnectReturnsTrue() {

		System.out.println("tryToConnect() should return true");

		boolean expected = true;
		boolean actual = SqlStuff.tryToConnect();

		assertEquals(expected, actual);

	}

	@Test
	public void testWhetherQueryReturnsNull() {

		System.out.println("query() should not return null");

		ResultSet actual = SqlStuff.query("SELECT * FROM Event");

		if (actual == null) {
			fail();
		}

	}

	@Test
	public void testWhetherQueryThrowsSQLException() throws SQLException {

		System.out.println("query() should not throw an SQLException");

		SqlStuff.query("SELECT * FROM Event");

	}
}
