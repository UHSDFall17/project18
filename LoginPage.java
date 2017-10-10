package Group18.EventBrite;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
public class LoginPage {
     public static void main(String args[])
     {
    	 String Password1=sc.next();
	        Connection conn = null;
	        String url = "jdbc:mysql://localhost:3306/eventbrite?useSSL=false";
	        String driver = "com.mysql.jdbc.Driver";
	        String userName = "root";
	        String password = "Munni@29041995";
	        Statement stmt = null;
    	 Scanner sc=new Scanner(System.in);
    	 //public static void loginpagefunction(String id)
    	 String id;
    	 System.out.println("Enter 1: Already existed User \n 2: New User");
    	 int loginselection=sc.nextInt();
    	 switch(loginselection)
    	 {
    	 	case 1: System.out.println("Enter Username");
    	 	        String Username=sc.next();
    	 	        System.out.println("Enter Password");
    	 	        
    	 	        String query = "select EmailID,Password from LoginUsers where EmailId='"+ Username+"' and Password='"+Password1+"' ";
    	 	        try
    	 	        {
    	 	            Class.forName(driver);
    	 	            conn = DriverManager.getConnection(url, userName, password);
    	 	            stmt = conn.createStatement();
    	 	           // System.out.println("Connected to the database");
    	 	            ResultSet rs = stmt.executeQuery(query);
    	 	            while (rs.next())
    	 	            {
    	 	               if(id=="Ticket Booking")
    	 	               {
    	 	            	   //direct to ticket booking
    	 	               }
    	 	               else if(id=="Create an event")
    	 	               {
    	 	            	   //direct to creating an event page
    	 	               }
    	 	               else
    	 	               {
    	 	               }   //Wrong user credentials
    	 	            }
    	 	            conn.close();
    	 	            //System.out.println("Disconnected from database");
    	 	        } catch (Exception e)
    	 	        {
    	 	            e.printStackTrace();
    	 	        }
    	 	        break;
    	 	case 2: System.out.println("Enter First Name");
    	 	        String Firstname=sc.next();
    	 	        System.out.println("Enter Last Name:");
    	 	        String Lastname=sc.next();
    	 	        System.out.println("Enter Email Id:");
    	 	        String EmailID=sc.next();
    	 	        System.out.println("Enter Phone Number:");
    	 	        int Phoneno=sc.nextInt();
    	 	        System.out.println("Enter password:");
    	 	        String Password=sc.next();
    	 	        System.out.println("Please Confirm the password by comparing them");
    	 	        String Pass=sc.next();
    	 	        
    	 	        stmt = conn.createStatement();
    	 	        if(Password==Pass)
    	 	        {
    	 	        	
        	 	        //String query = "select EmailID,Password from LoginUsers where EmailId='"+ Username+"' and Password='"+Password1+"' ";
        	 	        try
        	 	        {
        	 	            Class.forName(driver);
        	 	            conn = DriverManager.getConnection(url, userName, password);
        	 	            stmt = conn.createStatement();
        	 	           // System.out.println("Connected to the database");
        	 	           String SQL="Insert into LoginUsers values('"+Firstname+"','"+Lastname+"','"+EmailID+"',"+Phoneno+"','"+Password+"')";
        	 	           stmt.executeUpdate(SQL);

        	 	            conn.close();
        	 	            //System.out.println("Disconnected from database");
        	 	        } catch (Exception e)
        	 	        {
        	 	            e.printStackTrace();
        	 	        }
        	 	        break;
    	 	        	
    	 	        }
    	 	   
    	 	        
    	 
    	 }
	        
     }
}
