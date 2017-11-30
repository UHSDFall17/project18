package sd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

	public static final String url = "jdbc:mysql://localhost:3306/eventbrite?useSSL=false";
	public static final String driver = "com.mysql.jdbc.Driver";
	public static final String userName = "root";
	public static final String password = "Munni@29041995";
	public static Connection connection = onlyOneConnectionPerApplicationInstance();

	public static Connection onlyOneConnectionPerApplicationInstance() {

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.err.print(e);
		}

		try {
			return DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			System.err.print(e);
		}

		return null;

	}

	public static ResultSet query(String query) {

		try {
			return connection.createStatement().executeQuery(query);
		} catch (Exception e) {
			System.err.print(e);
		}

		return null;

	}

	public static int update(String query) {

		try {
			return connection.createStatement().executeUpdate(query);
		} catch (Exception e) {
			System.err.print(e);
		}

		return -1;

	}
}
