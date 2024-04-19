package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@Test()
	public void getBookDetails(String src,String dst,String price)
	{
		System.out.println(src+" "+dst+" "+price);
	}
	
	@DataProvider
	public Object[][] bookTicket()
	{
	    Object[][] obj = new Object[3][3];
	    
	    obj[0][0]="bglr";
	    obj[0][1]="delhi";
	    obj[0][2]="2000";
	    
	    obj[1][0]="delhi";
	    obj[1][1]="kerala";
	    obj[1][2]="4000";
	    
	    obj[2][0]="chennai";
	    obj[2][1]="bglr";
	    obj[2][2]="3000";
		return obj;
	}
}
