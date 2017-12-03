package Group18.Eventbrite;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class CreateEvent {
  public static void createevent() throws SQLException, ClassNotFoundException
  {
	  Scanner sc=new Scanner(System.in);
	 String a = null;
	 int i=0,number=0;
	  Connection conn = null;
      String url = "jdbc:mysql://localhost:3306/PROJECT?useSSL=false";
      String driver = "com.mysql.jdbc.Driver";
      String userName = "root";
      String password = "root";
      Statement stmt = null;
      String query1="select EventID from Event";
	  System.out.println("Enter Event Id");
      int eid=sc.nextInt();
      Class.forName(driver);
       conn = DriverManager.getConnection(url, userName, password);
       stmt = conn.createStatement();
       ResultSet rs1 = stmt.executeQuery(query1);
       rs1.last();
       int count=rs1.getRow();
       String[] b=new String[count];
       rs1.beforeFirst();
      while (rs1.next()) {
    	  a=rs1.getString(1); 
    	  b[i]=a;
    	  i++;
    	}
      while(true)
      {
    	  number=0;
    	  for(i=0;i<count;i++)
    	  {
    	  if(eid==Integer.parseInt(b[i]))
    	  {
    		 number++;
    	  }
    	  }
    	  if(number>0)
    	  {
    		 System.out.println("EventID is already in use:");
    		 System.out.println("Enter Event Id");
    	     eid=sc.nextInt(); 
    	  }
    	  else
    		  break;
    	  }
      System.out.println("Enter Event name");
      String name=sc.next();
      System.out.println("Enter Event Description");
      String eventdescription=sc.next();
      System.out.println("Enter Streetaddress");
      String street=sc.next();
      System.out.println("Enter City:");
      String city=sc.next();
      System.out.println("Enter state:");
      String state=sc.next();
      System.out.println("Enter Pincode:");
      int pincode=sc.nextInt();
      System.out.println("Enter Contact Phone Number:");
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
      System.out.println("Enter Date(yyyy-mm-dd) of the event");
      String date=sc.next();
      System.out.println("Enter Time(00:00:00) of the event");
      String time=sc.next();
      System.out.println("Number of tickets available for the event:");
      int no=sc.nextInt();
      
      try
       {
           Class.forName(driver);
           conn = DriverManager.getConnection(url, userName, password);
           stmt = conn.createStatement();
         String query="insert into Event values('"+eid+"','"+name+"','"+eventdescription+"','"+street+"','"+city+"','"+state+"',"+pincode+","+Phoneno+",'"+date+"','"+time+"',"+no+")";
           int rs=stmt.executeUpdate(query);
       }
      catch (Exception e)
       {
           e.printStackTrace();
       }
     

  }
}



