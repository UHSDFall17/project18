package sd;

import java.sql.*;
import java.util.*;

public class HomePage {

	public static void main(String args[]) {
		System.out.println("1.Corporate User 2.General User");
		Scanner in = new Scanner(System.in);
		int useroption = in.nextInt();
		switch (useroption) {
			case 1:
				System.out.println("Corporate user can only create a new events");
				new CLoginPage().corporateLoginPage();
				break;
			case 2:
				System.out.println("Enter 1 to  Search for an event \n Enter 2 to create an event");
				int selectoption = in.nextInt();
				switch (selectoption) {
					case 1:
						new SearchEvent().searchEvent();
						break;

					case 2:
						new CreateEvent().createEvent();
						break;
					default:
						System.out.println("Enter correct choice:");
				}
				break;
		}
	}
}
