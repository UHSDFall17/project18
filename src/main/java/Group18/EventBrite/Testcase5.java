package Group18.EventBrite;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class Testcase5 {

	@Test
	public void test() {
		LoginPage lp=new LoginPage();
		Scanner sc=new Scanner(System.in);
		System.out.println("Select requied operation: \n Ticket Booking \n Create an event");
		String choice=sc.nextLine();
		String output=lp.loginpagefunction(choice, 1);
		assertEquals("Registration Successfull",output);
	}

}
