package practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BronkenLinks {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		ArrayList<Object> brokenLinks = new ArrayList<Object>();
		for(int i=0;i<links.size();i++)
		{
			String allLinks = links.get(i).getAttribute("href");
			URL url;
			int statusCode=0;
			try {
				url=new URL(allLinks);
				URLConnection connection = url.openConnection();
				HttpURLConnection httpURLConnection = (HttpURLConnection)connection;
				statusCode=httpURLConnection.getResponseCode();
				if(statusCode>=400)
				{
					brokenLinks.add(allLinks+" "+statusCode);
				}
			} catch (Exception e) {
				// TODO: handle exception
				continue;
			}
		}
		System.out.println(brokenLinks);
	}

}
