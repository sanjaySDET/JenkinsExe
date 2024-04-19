package com.comcast.genericutlity;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class SeleniumGridBaseClass {
	public RemoteWebDriver driver;

	@Parameters("browser")
	@BeforeMethod
	public void config(String BROWSER) throws MalformedURLException {
		URL url = new URL("");
		DesiredCapabilities cap = new DesiredCapabilities();
		if (BROWSER.equalsIgnoreCase("chrome")) {
			cap.setPlatform(Platform.WINDOWS);
			cap.setBrowserName("chrome");
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			cap.setPlatform(Platform.WINDOWS);
			cap.setBrowserName("firefox");
		}
		driver = new RemoteWebDriver(url, cap);
	}
}
