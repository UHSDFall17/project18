package sd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class LoginPage {

	public static String loginpagefunction(String choice, int id) {
		int noofavailable;
		String S1 = "NULL";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/eventbrite?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "Munni@29041995";
		Statement stmt = null;
		System.out.println("Enter 1: Already existed User \n 2: New User");
		int loginselection = sc.nextInt();
		switch (loginselection) {
			case 1:
				System.out.println("Enter Username");
				String Username = sc.next();
				System.out.println("Enter Password");
				String Password1 = sc.next();
				String query = "select EmailID,Password from LoginUsers where EmailId='" + Username + "' and Password='" + Password1 + "' ";
				try {
					Class.forName(driver);
					conn = DriverManager.getConnection(url, userName, password);
					stmt = conn.createStatement();
					// System.out.println("Connected to the database");
					ResultSet rs = stmt.executeQuery(query);
					if (rs.next()) {
						if (choice.equals("Ticket Booking")) {
							String query1 = "select * from Event where EventID='" + id + "'";
							ResultSet rs1 = stmt.executeQuery(query1);
							if (rs1.next()) {
								noofavailable = Integer.parseInt(rs1.getString("NoofTickets"));
								if (noofavailable == 0) {
									System.out.println("No available Tickets");
									break;
								} else {
									System.out.println("Number of tickets wanna book:");
									int notickets = sc.nextInt();
									noofavailable = noofavailable - notickets;
									System.out.println("Event ID:" + rs1.getString("EventID") + "\n Event Name:" + rs1.getString("EventName")
											+ "\n Venue:" + rs1.getString("StreetAddress") + rs1.getString("City") + rs1.getString("State") + rs1.getString("Pincode")
											+ "\n Date of the event:" + rs1.getString("DateoftheEvent") + "Booking Confirmation: \n Number of tickets Booked:" + notickets);

									String query2 = "update Event SET NoofTickets='" + noofavailable + "' where EventID='" + id + "'";
									int rs2 = stmt.executeUpdate(query2);
									S1 = "Ticket Booked";

								}
							}


						} else if (choice.equals("Create an event")) {
							S1 = "Event Created";//direct to creating an event page
						} else {
							S1 = "Wrong Selection";
						}   //Wrong user credentials

					} //System.out.println("Disconnected from database");
					else {
						System.out.println("Login failed");
						System.out.println("1.Forgot password \n 2.New Registration");
						int option = sc.nextInt();
						switch (option) {
							case 1:
								System.out.println("Enter phone number for validation:");
								int pno = sc.nextInt();
								String query3 = "select * from LoginUsers where PhoneNo='" + pno + "'";
								ResultSet rs3 = stmt.executeQuery(query3);
								if (rs3.next()) {
									System.out.println("Enter New Password:");
									String pass = sc.next();
									String query4 = "update LoginUsers SET Password='" + pass + "',ConfirmPassword='" + pass + "' where PhoneNo='" + pno + "'";
									int rs4 = stmt.executeUpdate(query4);
									S1 = "Password Updated";
								} else {
									System.out.println("User not found:");
									System.out.println("Register:");
									RegistrationPage rp = new RegistrationPage();
									rp.register(1);
									S1 = "New Registration as user not found";
								}
								break;

							case 2:
								RegistrationPage rp = new RegistrationPage();
								rp.register(1);
								S1 = "New Registration is selected";
								break;

							default:
								System.out.println("Time out");
								S1 = "Time out";
								break;

						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				RegistrationPage rp = new RegistrationPage();
				S1 = rp.register(1);
				break;

			default:
				System.out.println("Time out");
				S1 = "Time out";
				break;
		}
		return S1;
	}
}
