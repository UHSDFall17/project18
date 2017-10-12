package Group18.EventBrite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlStuff {

	public static final String URL = "jdbc:mysql://localhost:3306/eventbrite?useSSL=false";
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "Munni@29041995";
	//	Let's do it this way so we don't have to make a brand new connection every time.
	private static Connection connection = null;
	private static boolean isConnected = tryToConnect();

	public static boolean tryToConnect() {

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace(System.err);
			isConnected = false;
			return isConnected;
		}

		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace(System.err);
			isConnected = false;
			return isConnected;
		}

		isConnected = true;
		return isConnected;

	}

	public static ResultSet query(String queryString) {

		if (!isConnected) {
			boolean itConnectedThisTime = tryToConnect();

			if (!itConnectedThisTime) {
				return null;
			}

		}

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(queryString);
			return resultSet;
		} catch (SQLException e) {
			e.printStackTrace(System.err);
			return null;
		}

	}
}
