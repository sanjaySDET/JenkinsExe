package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginToApplication {
     WebDriver driver;
	
	@Test(dataProvider = "getData")
	public void login(String username,String password)
	{
		driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj = new Object[2][2];
		
		obj[0][0]="admin";
		obj[0][1]="manager";
		
		obj[1][0]="admin";
		obj[1][1]="admin";
		return obj;
		
	}
}
