package Group18.Eventbrite;
import java.sql.*;
import java.util.*;
	public class HomePage {
		public static void main(String args[]) throws SQLException, ClassNotFoundException{
			System.out.println("1.Corporate User 2.General User");
			Scanner in = new Scanner(System.in);
			int useroption=in.nextInt();
			switch(useroption)
			{
			case 1:System.out.println("Corporate user can only create a new events");
			       CLoginPage Lp1=new CLoginPage();
			       Lp1.corporateloginpage();
				   break;
			case 2:System.out.println("Enter 1 to  Search for an event \n Enter 2 to create an event");
			int selectoption = in.nextInt();
			switch(selectoption)
			{
			  case 1: searchevent();
			          break;
				
			  case 2: LoginPage lp=new LoginPage();
			          lp.loginpagefunction(0);
			          break;
			  default: System.out.println("Enter correct choice:");        
			}
			       break;
		}
		}	
		public static int searchevent()
		{
			int count=0;
			Scanner sc = new Scanner(System.in);
			Connection conn = null;
	        String url = "jdbc:mysql://localhost:3306/PROJECT?useSSL=false";
	        String driver = "com.mysql.jdbc.Driver";
	        String userName = "root";
	        String password = "root";
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
	            	for(int i=1;i<=11;i++)
	            	{
	                System.out.print(rs.getString(i));
	                System.out.print("   ");
	            	}    
	            	System.out.println("\n");
	            }    LoginPage LP=new LoginPage();
	                System.out.println("Enter selected event ID:");
	                int selectevent=sc.nextInt();
	                LP.loginpagefunction(selectevent);
	            
	            conn.close();
	            //System.out.println("Disconnected from database");
	        } catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        return count;
		}
		
		
	}


