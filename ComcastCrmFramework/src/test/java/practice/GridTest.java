package practice;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.comcast.genericutlity.SeleniumGridBaseClass;

public class GridTest extends SeleniumGridBaseClass{

	@Test
	public void gridPractice() throws MalformedURLException
	{
//		URL url = new URL("http://192.168.0.103:4444/wd/hub");
//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setBrowserName("firefox");
//		cap.setPlatform(Platform.WINDOWS);
//		RemoteWebDriver driver = new RemoteWebDriver(url, cap);
//		driver.get("http://gmail.com");
		driver.get("https://www.facebook.com");
	}
}
