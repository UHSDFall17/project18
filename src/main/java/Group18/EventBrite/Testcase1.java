package Group18.EventBrite;

import junit.framework.TestCase;

public class Testcase1 extends TestCase {
     public void test1()
     {
    	 HomePage hp=new HomePage();
    	 int noofrows=hp.searchevent();
    	 assertEquals(2,noofrows);
    	 
    	 
     }
}
