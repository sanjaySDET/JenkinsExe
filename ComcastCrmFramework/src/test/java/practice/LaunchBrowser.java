package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {

	public static void main(String[] args) {
		
		//To run scripts in headless mode
//		ChromeOptions option = new ChromeOptions();
//		option.addArguments("--headless");
//		WebDriver driver=new ChromeDriver(option);
//		driver.get("https://www.amazon.in");
//		System.out.println(driver.findElement(By.xpath("//a[.='Amazon miniTV']")).getText());
		
		//To run scripts in incognito mode
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--incognito");
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.amazon.in");
		System.out.println(driver.findElement(By.xpath("//a[.='Amazon miniTV']")).getText());
	}
}
