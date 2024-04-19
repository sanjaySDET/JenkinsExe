package practice;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG {

	@BeforeTest
	public void bt()
	{
		System.out.println("before test");
	}
	
	@BeforeSuite
	public void bs()
	{
		System.out.println("before suite");
	}
	
	@BeforeMethod
	public void bm1()
	{
		System.out.println("before method1");
	}
	
	@BeforeClass
	public void bc()
	{
		System.out.println("before class");
	}
	
	@BeforeMethod
	public void bm2()
	{
		System.out.println("before method2");
	}
	
	@Test(priority = 0)
	public void btest1()
	{
	//	Assert.fail();
		System.out.println("bangalore");
	}
	
	@Test(priority = -1,invocationCount = 2,enabled = false)
	public void atest2()
	{
		System.out.println("delhi");
	}
	
	@Test(dependsOnMethods = "btest1")
	public void test3()
	{
		System.out.println("chennai");
	}
	
	@AfterClass
	public void ac()
	{
		System.out.println("after class");
	}
	
	@AfterSuite
	public void as()
	{
		System.out.println("after suite");
	}
	
	@AfterTest
	public void at()
	{
		System.out.println("after test");
	}
	
	@AfterMethod
	public void am()
	{
		System.out.println("after method");
	}
}