package Group18.EventBrite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;

public class RegistrationPage {

	public static void main(String args[]) {
	}

	public static void register() {
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
			String query = "insert into LoginUsers values ('" + Firstname + "','" + Lastname + "','" + EmailID + "'," + Phoneno + ",'" + Password + "','" + Pass + "')";
			//String query="insert into LoginUsers values ('ravali','basna','ravali@gmail.com','12345678','munni','munni')";
			int rs = stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
