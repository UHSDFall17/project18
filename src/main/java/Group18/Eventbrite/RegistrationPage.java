package sd;

import Group18.Eventbrite.Database;
import java.util.*;

public class RegistrationPage {

	public static String register(int x) {
		String S1 = "NULL";
		String query;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Name");
		String Firstname = sc.next();
		System.out.println("Enter Last Name:");
		String Lastname = sc.next();
		System.out.println("Enter Email Id:");
		String EmailID = sc.next();
		System.out.println("Enter Phone Number:");
		int Phoneno = sc.nextInt();
		System.out.println("Enter password:");
		String Password = sc.next();
		System.out.println("Please Confirm the password:");
		String Pass = sc.next();
		try {
			if (x == 0) {
				System.out.println("Enter company name:");
				String comname = sc.next();
				query = "insert into CorporateLoginUsers values ('" + Firstname + "','" + Lastname + "','" + EmailID + "'," + Phoneno + ",'" + Password + "','" + Pass + "','" + comname + "')";
			} else {
				query = "insert into LoginUsers values ('" + Firstname + "','" + Lastname + "','" + EmailID + "'," + Phoneno + ",'" + Password + "','" + Pass + "')";
			}
			Database.update(query);
			S1 = "Registration Successfull";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return S1;
	}
}
