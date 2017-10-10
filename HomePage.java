package Group18.EventBrite;
import java.sql.*;
import java.util.*;
public class HomePage {
	public static void main(String args[]){
		System.out.println("Enter 1 to  Search for an event \n Enter 2 to create an event");
		Scanner in = new Scanner(System.in);
		int selectoption = in.nextInt();
		switch(selectoption)
		{
		  case 1: searchevent();
		          break;
			
		  case 2: CreateEvent ce=new CreateEvent();
		          break;
		}
	}
	public static void searchevent()
	{
		Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/eventbrite?useSSL=false";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "Munni@29041995";
        Statement stmt = null;
        String query = "select * from Event";
        try
        {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, password);
            stmt = conn.createStatement();
           // System.out.println("Connected to the database");
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                LoginPage LP=new LoginPage();
                LP.loginpagefunction("Ticket Booking");
            }
            conn.close();
            //System.out.println("Disconnected from database");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
	}
	

}
