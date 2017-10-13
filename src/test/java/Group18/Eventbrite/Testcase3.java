<<<<<<< HEAD
package Group18.Eventbrite;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
public class Testcase3 {

	@Test
	public void test() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Select requied operation: \n Ticket Booking \n Create an event");
		String choice=sc.nextLine();
		LoginPage lp=new LoginPage();
		String output=lp.loginpagefunction(choice,1);
		assertEquals("Ticket Booked",output);
	}

}
=======
package Group18.Eventbrite;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
public class Testcase3 {

	@Test
	public void test() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Select requied operation: \n Ticket Booking \n Create an event");
		String choice=sc.nextLine();
		LoginPage lp=new LoginPage();
		String output=lp.loginpagefunction(choice,1);
		assertEquals("Ticket Booked",output);
	}

}
>>>>>>> e055a7ace2af7f9e085f1fac30d0fc8b5bf0bf90
