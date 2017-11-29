package sd;

import Group18.Eventbrite.Database;
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
						searchevent();
						break;

					case 2:
						CreateEvent ce1 = new CreateEvent();
						ce1.createevent();
						break;
					default:
						System.out.println("Enter correct choice:");
				}
				break;
		}
	}

	public static int searchevent() {
		int count = 0;
		Scanner sc = new Scanner(System.in);
		String query = "select * from Event";
		try {
			ResultSet rs = Database.query(query);
			rs.last();
			count = rs.getRow();
			System.out.println("Number of rows:" + count);
			while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));

			}
			LoginPage LP = new LoginPage();
			System.out.println("Enter selected event ID:");
			int selectevent = sc.nextInt();
			LP.loginpagefunction("Ticket Booking", selectevent);
			//System.out.println("Disconnected from database");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
