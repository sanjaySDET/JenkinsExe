package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownPractice {

	@Test
	public void CountOptionsInDropdown()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:8888/index.php?module=Accounts&action=EditView&return_action=DetailView&parenttab=Marketing");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).submit();
		WebElement element1 = driver.findElement(By.name("accounttype"));
		Select select=new Select(element1);
		List<WebElement> option = select.getOptions();
		int count = option.size();
		System.out.println(count);
	}
	
	@Test
	public void ToFetchOptionsFromDropDown()
	{
		 WebDriver driver=new ChromeDriver();
			driver.get("http://localhost:8888/index.php?module=Accounts&action=EditView&return_action=DetailView&parenttab=Marketing");
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).submit();
			WebElement element1 = driver.findElement(By.name("accounttype"));
	             Select select = new Select(element1);
			List<WebElement> options = select.getOptions();
			for (WebElement option : options) 
			{
				String text = option.getText();
				System.out.println(text);
			}
	}
	
	@Test
	public void ToCheckOptionPresentOrNot()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
//		Random random=new Random();
//		int randNum = random.nextInt();
		
		driver.get("http://localhost:8888/index.php?module=Accounts&action=EditView&return_action=DetailView&parenttab=Marketing");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).submit();
		WebElement element1 = driver.findElement(By.name("accounttype"));
		Select select=new Select(element1);
		TreeSet<String> set=new TreeSet<String>();
		List<WebElement> option = select.getOptions();
		for (WebElement webElement : option) 
		{
			String altext = webElement.getText();
			set.add(altext);
		}
		if(set.contains("Other"))
		{
			System.out.println("dropdown is present");
		}else {
			System.out.println("dropdown is not present");
		}
	}
		@Test
		public void FetchAndPrintOptionsInAscendingOrderUsingTreeSet()
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			
			driver.get("http://localhost:8888/index.php?module=Accounts&action=EditView&return_action=DetailView&parenttab=Marketing");
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).submit();
			WebElement element1 = driver.findElement(By.name("accounttype"));
			Select select=new Select(element1);
			TreeSet<String> set=new TreeSet<String>();
			List<WebElement> option = select.getOptions();
			for (WebElement webElement : option) 
			{
				String altext = webElement.getText();
				set.add(altext);
			}
			for (String sorted : set) 
			{
			System.out.println(sorted);	
			}
		}
		
		@Test
		public void printOptionsInAscOrder()
		{
			WebDriver driver = WebDriverManager.chromedriver().create();
			driver.manage().window().maximize();
			driver.get("http://localhost:8888/index.php?module=Accounts&action=EditView&return_action=DetailView&parenttab=Marketing");
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).submit();
			WebElement element1 = driver.findElement(By.name("accounttype"));
			Select sel = new Select(element1);
			ArrayList<String> list = new ArrayList<String>();
			List<WebElement> option = sel.getOptions();
			for (WebElement webEle : option) 
			{
				String altext = webEle.getText();
				list.add(altext);
			}
			Collections.sort(list);
			for (String sortedText : list) 
			{
				System.out.println(sortedText);
			}
		}
		
		@Test
		public void PrintAllTheOptionsInDescendingOrder()
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			
			driver.get("http://localhost:8888/index.php?module=Accounts&action=EditView&return_action=DetailView&parenttab=Marketing");
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).submit();
			WebElement element1 = driver.findElement(By.name("accounttype"));
			Select select=new Select(element1);
			TreeSet<String> set=new TreeSet<String>(Collections.reverseOrder());
			List<WebElement> option = select.getOptions();
			for (WebElement webElement : option) 
			{
				String altext = webElement.getText();
				set.add(altext);
			}
			for (String sorted : set) 
			{
				System.out.println(sorted);
			}
		}
		
		@Test
		public void reverseorderusingArrayList()
		{
			WebDriver driver = WebDriverManager.chromedriver().create();
			driver.manage().window().maximize();
			driver.get("http://localhost:8888/index.php?module=Accounts&action=EditView&return_action=DetailView&parenttab=Marketing");
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).submit();
			WebElement element1 = driver.findElement(By.name("accounttype"));
			Select sel = new Select(element1);
			ArrayList<String> list = new ArrayList<String>();
			List<WebElement> option = sel.getOptions();
			for (WebElement webEle : option) 
			{
				String altext = webEle.getText();
				list.add(altext);
			}
			Collections.sort(list,Collections.reverseOrder());
			for (String sortedText : list) 
			{
				System.out.println(sortedText);
			}
		}
}
