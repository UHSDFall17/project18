package Group18.Eventbrite;

import junit.framework.TestCase;

public class Testcase1 extends TestCase {
     public void test1()
     {
    	 HomePage hp=new HomePage();
    	 int noofrows=hp.searchevent();
    	 System.out.println(noofrows);
    	 assertEquals(2,noofrows);
    	 
    	 
     }
}
