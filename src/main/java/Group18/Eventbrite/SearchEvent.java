package sd;

import java.sql.ResultSet;
import java.util.Scanner;

public class SearchEvent {

	public int searchEvent() {
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
