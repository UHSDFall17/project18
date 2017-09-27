import java.util.*;
public class EventBrite{
	public static void main(String [] args){
	String username,password;
	System.out.println("Enter your username");
	Scanner s= new Scanner(System.in);
	username=s.next();
	System.out.println("Enter your password");
	password=s.next();
	searchevent();
	
	
	
	}
	public static void searchevent(){
		String [] str=new String[5];
		int Eventno;
        Scanner s= new Scanner(System.in);
	str[0]="dancing Saturdays 10/12/2017 4:30PM Holly Hall";
	str[1]="friday night monster 10/13/2017 4:30PM Downtown";
	str[2]="set wednesdays 10/12/2017 6:30PM Scott street";
	str[3]="story thursday 10/15/2017 4:30PM Clear Lake";
	str[4]="mercy fridays 10/12/2017 8:30PM downtown";
	System.out.println("Upcoming Events");
	for(int i=0;i<5;i++){
		System.out.println(str[i]+"Event Number = "+i);
	} 
	System.out.print("Enter the event number");
	Eventno=s.nextInt();
	System.out.println("your ticket has been confirmed for event"+str[Eventno]);
	
		
	}
}