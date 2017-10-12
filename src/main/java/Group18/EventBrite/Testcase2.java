package Group18.EventBrite;

import static org.junit.Assert.*;

import org.junit.Test;
public class Testcase2 {

	@Test
	public void test2()
	{
		RegistrationPage rp=new RegistrationPage();
		String output=rp.register();
		assertEquals("Registration Successfull",output);
	}

}
