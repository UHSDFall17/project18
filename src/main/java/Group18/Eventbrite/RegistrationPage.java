package Group18.Eventbrite;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class RegistrationPage {
	
	
		public static String register(int x) throws ClassNotFoundException, SQLException
		{       String a1,a2,a3,a4;
		int i=0,number=0;
			 Connection conn = null;
		        String url = "jdbc:mysql://localhost:3306/PROJECT?useSSL=false";
		        String driver = "com.mysql.jdbc.Driver";
		        String userName = "root";
		        String password = "root";
		        Statement stmt = null;
			    String S1="NULL";
			    String query,query1;
			    Scanner sc=new Scanner(System.in);
			    System.out.println("Enter First Name");
		        String Firstname=sc.next();
		        System.out.println("Enter Last Name:");
		        String Lastname=sc.next();
		        if(x==0)
		        query1="select EmailID,PhoneNo,Username from corporateloginusers";
		        else
		        	query1="select EmailID,PhoneNo,Username from loginusers";
		        Class.forName(driver);
 	            conn = DriverManager.getConnection(url, userName, password);
 	            stmt = conn.createStatement();
 	            ResultSet rs1 = stmt.executeQuery(query1);
		        System.out.println("Enter Email Id:");
		        String EmailID=sc.next();
		        while(true)
		        {
		        	if((!(EmailID.contains("@")))||((!(EmailID.contains(".com"))))) {
		        	System.out.println("Enter Emailid:");
		        	EmailID=sc.next();
		        }
		        	else
		        		break;
		        }
		        rs1.last();
		        int count=rs1.getRow();
		        String[] b=new String[count];
		        String[] c=new String[count];
		        //String[] d=new String[count];
		        String[] f=new String[count];
		        rs1.beforeFirst();
		       while (rs1.next()) {
		     	  a1=rs1.getString(1);
		     	  a2=rs1.getString(2);
		     	 // a3=rs1.getString(3);
		     	  a3=rs1.getString(3);
		     	  b[i]=a1;
		     	  c[i]=a2;
		     	  f[i]=a3;
		     	  //f[i]=a4;
		     	  i++;
		     	}
		       while(true)
		       {
		     	  number=0;
		     	  for(i=0;i<count;i++)
		     	  {
		     	  if(EmailID.equals(b[i]))
		     	  {
		     		 number++;
		     	  }
		     	  }
		     	  if(number>0)
		     	  {
		     		 System.out.println("EmailID is already in use:");
		     		 System.out.println("Enter another EmailId");
		     	     EmailID=sc.next(); 
		     	    while(true)
			        {
			        	if((!(EmailID.contains("@")))||((!(EmailID.contains(".com"))))) {
			        	System.out.println("Enter Emailid:");
			        	EmailID=sc.next();
			        }
			        	else
			        		break;
			        }
		     	  }
		     	  else
		     		  break;
		     	  }
		        System.out.println("Enter Phone Number:");
		        long Phoneno=sc.nextLong();
		        
		        while(true)
		        {
		        	int length=(int)(Math.log10(Phoneno)+1);
		        	if(length!=10)
		        	{
		        		System.out.println("Enter Phone nUmber:");
		        		Phoneno=sc.nextLong();
		        	}
		        	else
		        		break;
		        }
		        while(true)
			       {
			     	  number=0;
			     	  for(i=0;i<count;i++)
			     	  {
			     	  if(Phoneno==Long.parseLong(c[i]))
			     	  {
			     		 number++;
			     	  }
			     	  }
			     	  if(number>0)
			     	  {
			     		 System.out.println("Phone number is already in use:");
			     		 System.out.println("Enter another Phonenumber");
			     	     Phoneno=sc.nextLong(); 
			     	    while(true)
				        {
			     	    	int length=(int)(Math.log10(Phoneno)+1);
				        	if(length!=10)
				        	{
				        		System.out.println("Enter Phone nUmber:");
				        		Phoneno=sc.nextLong();
				        	}
				        	else
				        		break;
				        }
			     	  }
			     	  else
			     		  break;
			     	  }
		        System.out.println("Enter Streetaddress");
		        String street=sc.next();
		        System.out.println("Enter City:");
		        String city=sc.next();
		        System.out.println("Enter state:");
		        String state=sc.next();
		        System.out.println("Enter Pincode:");
		        int pincode=sc.nextInt();
		        System.out.println("Enter Username:");
		        String username=sc.next();
		        while(true)
		        {
		        	if(username.length()<5||username.length()>15)
		        	{
		        		System.out.println("Enter Username:");
		        		username=sc.next();
		        	}
		        	else
		        		break;
		        }
		        while(true)
			       {
			     	  number=0;
			     	  for(i=0;i<count;i++)
			     	  {
			     	  if(username.equals(f[i]))
			     	  {
			     		 number++;
			     	  }
			     	  }
			     	  if(number>0)
			     	  {
			     		 System.out.println("Username is already in use:");
			     		 System.out.println("Enter another username");
			     	     username=sc.next(); 
			     	    while(true)
				        {
			     	    	if(username.length()<5||username.length()>15)
				        	{
				        		System.out.println("Enter Username:");
				        		username=sc.next();
				        	}
				        	else
				        		break;
				        }
			     	  }
			     	  else
			     		  break;
			     	  }
		        System.out.println("Enter password:");
		        String Password=sc.next();
		        while(true)
		        {
		        	if(Password.length()<8||Password.length()>15||(!(Password.matches("^.*[^a-zA-Z0-9 ].*$")))||(!(Password.matches(".*\\d+.*"))))
		        	{
		        		System.out.println("Enter Password:");
		        		Password=sc.next();
		        	}
		        	else
		        		break;
		        }
		        System.out.println("Please Confirm the password:");
		        String Pass=sc.next();
		        while(true)
		        {
		        	if(!(Password.equals(Pass)))
		        	{
		        		System.out.println("Password doesn't match renter to confirm the password:");
		        		Pass=sc.next();
		        	}
		        	else
		        		break;
		        }
		        try
	 	        {
	 	            
	 	            if(x==0)
	 	            {
	 	              System.out.println("Enter company name:");
	 	              String comname=sc.next();
	 	              System.out.println("Enter Employee Id:");
	 	              int EmpId=sc.nextInt();
		              query = "insert into CorporateLoginUsers values ('"+Firstname+"','"+Lastname+"','"+EmailID+"',"+Phoneno+",'"+comname+"','"+street+"','"+city+"','"+state+"',"+pincode+","+EmpId+",'"+username+"','"+Password+"','"+Pass+"')";
	 	              int rs=stmt.executeUpdate(query);
		              S1="Registration Successfull";
	 	             }
	 	            else
	 	            {
	 	              query="insert into LoginUsers values ('"+Firstname+"','"+Lastname+"','"+EmailID+"',"+Phoneno+",'"+street+"','"+city+"','"+state+"',"+pincode+",'"+username+"','"+Password+"','"+Pass+"')";	
	 	            int rs=stmt.executeUpdate(query);
	 	            S1="Registration Successfull";
	 	        }
	 	        }
		        catch (Exception e)
	 	        {
	 	            e.printStackTrace();
	 	        }
	 	      
		       return S1; 
             
              
		}
	}

