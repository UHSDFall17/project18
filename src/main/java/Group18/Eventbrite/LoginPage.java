package Group18.Eventbrite;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class LoginPage {
	public static int noofavailable;
	public static Statement stmt = null;
	public static String S1="NULL";
    public static String loginpagefunction(int id) throws SQLException, ClassNotFoundException
    {
    	
    	
    	 Scanner sc=new Scanner(System.in);
	        Connection conn = null;
	        String url = "jdbc:mysql://localhost:3306/PROJECT?useSSL=false";
	        String driver = "com.mysql.jdbc.Driver";
	        String userName = "root";
	        String password = "root";
	        
    	 System.out.println("Enter 1: Already existed User \n 2: New User");
    	 int loginselection=sc.nextInt(); 
    	 switch(loginselection)
    	 {
    	 	case 1: System.out.println("Enter Username");
    	 	        String Username=sc.next();
    	 	        System.out.println("Enter Password");
    	 	        String Password1=sc.next();
    	 	        String query = "select Username,password1 from LoginUsers where Username='"+ Username+"' and password1='"+Password1+"' ";
    	 	        try
    	 	        {
    	 	            Class.forName(driver);
    	 	            conn = DriverManager.getConnection(url, userName, password);
    	 	            stmt = conn.createStatement();
    	 	           // System.out.println("Connected to the database");
    	 	            ResultSet rs = stmt.executeQuery(query);
    	 	            if(id==0)
    	 	            {
    	 	            	if(rs.next()) {
    	 	            		CreateEvent ce=new CreateEvent();
    	 	            		ce.createevent();
    	 	            	}
    	 	            	else
    	 	            	{
    	 	            		System.out.println("Login Failed:");
    	 	            		function(id);
    	 	            	}
    	 	            }
    	 	            else 
    	 	            {
    	 	            if(rs.next())
    	 	            {     
    	 	               S1=function2(id);	   
    	 	            }
    	 	            else
    	 	            {
    	 	            	function(id);
    	 	            }
    	 	                
    	 	            }
    	 	             
    	 	            }
    	 	            //System.out.println("Disconnected from database");
    	 	       catch (Exception e)
    	 	        {
    	 	            e.printStackTrace();
    	 	        }
    	 	        break;
    	 	case 2: RegistrationPage rp=new RegistrationPage();
    	 	        S1=rp.register(1);
    	 	        if(id==0)
    	 	        	{CreateEvent ce=new CreateEvent();
            		ce.createevent();
    	 	        	}
    	 	        else
    	 	        {
    	 	        	S1=function2(id);
    	 	        }
    	 	        break;
    	 	        
    	 	default:System.out.println("Time out"); 
    	 	        S1="Time out";
    	            break;
    	 }
    	 return S1;
    }
   public static String function2(int id) throws SQLException
    	 	     {
    	 	    	String query1="select * from Event where EventID="+id+"";
	            	   ResultSet rs1=stmt.executeQuery(query1);
	            	   Scanner sc=new Scanner(System.in);
	            	   if(rs1.next())
	            	   {
	            		 noofavailable=Integer.parseInt(rs1.getString("NoofTickets"));
	            		if(noofavailable==0)
	            		{		
	            		   System.out.println("No available Tickets");
	            		   S1="Not booked";
	            		}     	   
	            	    else
	                     {
	            		   System.out.println("Number of tickets wanna book:");
	            	       int notickets=sc.nextInt();
	            	       noofavailable=noofavailable-notickets;
	            	     System.out.println("\n Booking Confirmation: Event ID:"+rs1.getString("EventID")+"\n Event Name:"+rs1.getString("EventName")
	            	       +"\n Venue:"+rs1.getString("StreetAddress")+rs1.getString("City")+rs1.getString("State")+rs1.getString("Pincode")+
	            	       "\n Date of the event:"+rs1.getString("DateoftheEvent")+"\n Time:"+rs1.getString("TimeoftheEvent")+"\n Number of tickets Booked:"+notickets);
	                       
	            	      String query2="update Event SET NoofTickets='"+noofavailable+"' where EventID='"+id+"'";
	            	      int rs2=stmt.executeUpdate(query2);
	            	      S1="Ticket Booked";
	            	      
	                     }
	            	   }
	            	   return S1;
    	 	     }
    	public static void function(int id) throws SQLException, ClassNotFoundException
    	 	     {
    		 Scanner sc=new Scanner(System.in);
    	 	        	System.out.println("1.Forgot password \n 2.New Registration");
    	 	        	int option=sc.nextInt();
    	 	        	switch(option)
    	 	        	{
    	 	        	case 1: System.out.println("Enter phone number for validation:");
    	 	        	        long pno=sc.nextLong();
    	 	        	       while(true)
    	 	  		        {
    	 	  		        	int length=(int)(Math.log10(pno)+1);
    	 	  		        	if(length!=10)
    	 	  		        	{
    	 	  		        		System.out.println("Enter Phone nUmber:");
    	 	  		        	    pno=sc.nextLong();
    	 	  		        	}
    	 	  		        	else
    	 	  		        		break;
    	 	  		        }
    	 	        	        String query3="select * from LoginUsers where PhoneNo='"+pno+"'";
    	 	        	        ResultSet rs3 = stmt.executeQuery(query3);
    	 	        	        if(rs3.next())
    	 	        	        {
    	 	        	        	System.out.println("Enter New Password:");
    	 	        	        	String pass=sc.next();
    	 	        	        	String query4="update LoginUsers SET password1='"+pass+"',confirmpassword='"+pass+"' where PhoneNo='"+pno+"'";
    	 	        	        	int rs4=stmt.executeUpdate(query4);
    	 	        	        	S1="Password Updated";
    	 	        	        	if(id==0)
    	 	        	        	{
    	 	        	        		CreateEvent ce=new CreateEvent();
    	 	        	        		ce.createevent();
    	 	        	        	}
    	 	        	        	else
    	 	        	        	{
    	 	        	        		function2(id);
    	 	        	        	}
    	 	        	        }
    	 	        	        else
    	 	        	        {
    	 	        	        	System.out.println("User not found:");
    	 	        	        	System.out.println("Register:");
    	 	        	        	RegistrationPage rp=new RegistrationPage();
    	 	       	 	            rp.register(1);
    	 	       	 	            S1="New Registration as user not found";
    	 	       	 	       if(id==0)
	 	        	        	{
	 	        	        		CreateEvent ce=new CreateEvent();
	 	        	        		ce.createevent();
	 	        	        	}
    	 	       	 	       else
    	 	       	 	       {
    	 	       	 	    	   function2(id);
    	 	       	 	       }
    	 	        	        }   
    	 	        	        break;
 
    	 	        	case 2: RegistrationPage rp=new RegistrationPage();
	       	 	            rp.register(1);
	       	 	            S1="New Registration is selected";
	       	 	            if(id==0)
	        	        	{
	        	        		CreateEvent ce=new CreateEvent();
	        	        		ce.createevent();
	        	        	}
	       	 	            else
	       	 	            	function2(id);
	       	 	            break;
	       	 	               
	       	 	        default: System.out.println("Time out");  
	       	 	                 S1="Time out";
	       	 	                 break;
	       	 	               
    	 	        	}
    	 	        } 
}
    	 	        	
    	 	        
   


