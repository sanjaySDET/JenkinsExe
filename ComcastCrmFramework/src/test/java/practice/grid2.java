package practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class grid2 {
public static void main(String[] args) {
	String hubUrl="http://10.10.61.201:4444/wd/hub";
	DesiredCapabilities capabilities = new DesiredCapabilities();
	System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
	 try {
         // Create a RemoteWebDriver instance to connect to the Grid Hub
         WebDriver driver = new RemoteWebDriver(new URL(hubUrl), capabilities);

         // Open a website
         driver.get("https://www.google.com");
         driver.quit();
     } catch (MalformedURLException e) {
         e.printStackTrace();
     }
}
}
