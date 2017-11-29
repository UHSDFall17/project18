package sd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class CreateEvent {

	public static void createevent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Event Id");
		int eid = sc.nextInt();
		System.out.println("Enter Event name");
		String name = sc.next();
		System.out.println("Enter Event Description");
		String eventdescription = sc.next();
		System.out.println("Enter Contact Phone ?Number:");
		double Phoneno = sc.nextInt();
		System.out.println("Date");
		String date = sc.next();
		System.out.println("Time");
		String time = sc.next();
		System.out.println("Location:");
		String location = sc.next();
		System.out.println("Number of tickets available for the event:");
		int no = sc.nextInt();
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/eventbrite?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "Munni@29041995";
		Statement stmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, password);
			stmt = conn.createStatement();
			String query = "insert into Events values( '" + eid + "','" + name + "','" + eventdescription + "'," + Phoneno + ",'" + date + "','" + time + "','" + location + "','" + no + "')";
			int rs = stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
