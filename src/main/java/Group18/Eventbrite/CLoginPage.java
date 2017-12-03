package Group18.Eventbrite;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CLoginPage {
	 public static String corporateloginpage() throws ClassNotFoundException, SQLException
	    {
	    	String S1="NULL";
	    	 Scanner sc=new Scanner(System.in);
		        Connection conn = null;
		        String url = "jdbc:mysql://localhost:3306/PROJECT?useSSL=false";
		        String driver = "com.mysql.jdbc.Driver";
		        String userName = "root";
		        String password = "root";
		        Statement stmt = null;
	    	 System.out.println("Enter 1: Already existed Corporate User \n 2: New Corporate User");
	    	 int loginselection=sc.nextInt();
	    	 switch(loginselection)
	    	 {
	    	 	case 1: System.out.println("Enter Username");
	    	 	        String Username=sc.next();
	    	 	        System.out.println("Enter Password");
	    	 	        String Password1=sc.next();
	    	 	        String query = "select Username,password1 from CorporateLoginUsers where Username='"+ Username+"' and password1='"+Password1+"' ";
	    	 	        try
	    	 	        {
	    	 	            Class.forName(driver);
	    	 	            conn = DriverManager.getConnection(url, userName, password);
	    	 	            stmt = conn.createStatement();
	    	 	           // System.out.println("Connected to the database");
	    	 	            ResultSet rs = stmt.executeQuery(query);
	    	 	            if(rs.next())
	    	 	            {          
	    	 	            	CreateEvent ce=new CreateEvent();
	    	 			       ce.createevent();
	    	 	                     
	    	 	            }
	    	 	        else
	    	 	        {
	    	 	        	System.out.println("Login failed");
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
	    	 	        	        String query3="select * from CorporateLoginUsers where PhoneNo='"+pno+"'";
	    	 	        	        ResultSet rs3 = stmt.executeQuery(query3);
	    	 	        	        if(rs3.next())
	    	 	        	        {
	    	 	        	        	System.out.println("Enter New Password:");
	    	 	        	        	String pass=sc.next();
	    	 	        	        	String query4="update CorporateLoginUsers SET password1='"+pass+"',confirmpassword='"+pass+"' where PhoneNo='"+pno+"'";
	    	 	        	        	int rs4=stmt.executeUpdate(query4);
	    	 	        	        	S1="Password Updated";
	    	 	        	        	CreateEvent ce=new CreateEvent();
	    		    	 			    ce.createevent();
	    		    	 	                     
	    	 	        	        }
	    	 	        	        else
	    	 	        	        {
	    	 	        	        	System.out.println("CorporateUser not found:");
	    	 	        	        	System.out.println("Register:");
	    	 	        	        	RegistrationPage rp=new RegistrationPage();
	    	 	       	 	            rp.register(0);
	    	 	       	 	            S1="New Registration as user not found";
	    	 	       	 	            CreateEvent ce=new CreateEvent();
	    	 	       	 	            ce.createevent();
		    	 	                     
	    	 	        	        }   
	    	 	        	        break;
	 
	    	 	        	case 2: RegistrationPage rp=new RegistrationPage();
		       	 	            rp.register(0);
		       	 	            S1="New Registration is selected";
		       	 	            CreateEvent ce=new CreateEvent();
	    	 			        ce.createevent(); 
		       	 	            break;
		       	 	               
		       	 	        default: System.out.println("Time out");  
		       	 	                 S1="Time out";
		       	 	                 break;
		       	 	               
	    	 	        	}
	    	 	        } 	
	    	 	        }	
	    	 	        catch (Exception e)
	    	 	        {
	    	 	            e.printStackTrace();
	    	 	        }
	    	 	        break;
	    	 	case 2: RegistrationPage rp=new RegistrationPage();
	    	 	        S1=rp.register(0);
	    	 	        CreateEvent ce=new CreateEvent();
	    	 	        ce.createevent();
	 	                break;
	    	 	        
	    	 	default:System.out.println("Time out"); 
	    	 	        S1="Time out";
	    	            break;
	    	 }
	    	 return S1;
	    }    
	     }

