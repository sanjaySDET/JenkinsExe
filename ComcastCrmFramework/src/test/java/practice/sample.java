package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sample {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		WebElement ele = driver.findElement(By.name("user_name"));
		ele.sendKeys("admin");

		ele.sendKeys(Keys.CONTROL, "a");
		ele.sendKeys(Keys.CONTROL, "c");

		Thread.sleep(2000);

		WebElement ele1 = driver.findElement(By.name("user_password"));
		ele1.sendKeys(Keys.CONTROL, "v");
	}
}
