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
				CLoginPage Lp1 = new CLoginPage();
				Lp1.corporateloginpage();
				break;
			case 2:
				System.out.println("Enter 1 to  Search for an event \n Enter 2 to create an event");
				int selectoption = in.nextInt();
				switch (selectoption) {
					case 1:
						SearchEvent.searchEvent();
						break;

					case 2:
						CreateEvent.createEvent();
						break;
					default:
						System.out.println("Enter correct choice:");
				}
				break;
		}
	}
}
