package sd;

import Group18.Eventbrite.Database;
import java.util.*;

public class CreateEvent {

	public static void createevent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Event Id");
		int eid = sc.nextInt();
		System.out.println("Enter Event name");
		String name = sc.next();
		System.out.println("Enter Event Description");
		String eventdescription = sc.next();
		System.out.println("Enter Contact Phone ?Number:");
		double Phoneno = sc.nextInt();
		System.out.println("Date");
		String date = sc.next();
		System.out.println("Time");
		String time = sc.next();
		System.out.println("Location:");
		String location = sc.next();
		System.out.println("Number of tickets available for the event:");
		int no = sc.nextInt();
		try {
			String query = "insert into Events values( '" + eid + "','" + name + "','" + eventdescription + "'," + Phoneno + ",'" + date + "','" + time + "','" + location + "','" + no + "')";
			Database.update(query);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
