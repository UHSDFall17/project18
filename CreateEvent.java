package Group18.EventBrite;
import java.sql.*;
public class CreateEvent {
	int EventID,Pincode,NoofTickets;
	String EventName,StreetAddress,City,State;
	Date DateoftheEvent;
	
       public int getEventID() {
		return EventID;
	}

	public void setEventID(int eventID) {
		EventID = eventID;
	}

	public int getPincode() {
		return Pincode;
	}

	public void setPincode(int pincode) {
		Pincode = pincode;
	}

	public int getNoofTickets() {
		return NoofTickets;
	}

	public void setNoofTickets(int noofTickets) {
		NoofTickets = noofTickets;
	}

	public String getEventName() {
		return EventName;
	}

	public void setEventName(String eventName) {
		EventName = eventName;
	}

	public String getStreetAddress() {
		return StreetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		StreetAddress = streetAddress;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public Date getDateoftheEvent() {
		return DateoftheEvent;
	}

	public void setDateoftheEvent(Date dateoftheEvent) {
		DateoftheEvent = dateoftheEvent;
	}

	public static void main(String args[])
       {
    	   
       }
}
