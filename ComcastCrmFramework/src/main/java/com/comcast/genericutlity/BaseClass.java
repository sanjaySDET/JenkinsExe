package com.comcast.genericutlity;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.VtigerObjectRepsitory.HomePage;
import com.comcast.VtigerObjectRepsitory.LoginPage;

public class BaseClass {

	public static WebDriver sdriver;
	public WebDriver driver=null;
	public FileUtlity fLib=new FileUtlity();
	public JavaUtlity jLib=new JavaUtlity();
	public ExcelUtlity eLib=new ExcelUtlity();
	public DataBaseUtility dLib=new DataBaseUtility();
	public WebActionUtility wLib=new WebActionUtility();
	public JavaScriptUtility jaLib=new JavaScriptUtility(driver);
	public String ENV_FILE_PATH;
	public String TEST_SCRIPT_EXCEL_FILE_PATH;
	/**
	 * connecting to MYSQL database
	 * @throws SQLException
	 */
	@BeforeSuite(groups = {"smokeTest","regTest"})
	public void connectToDB() throws SQLException
	{
		dLib.connectDB();
		System.out.println("dataBase connection established");
	}

	/**
	 * launching the browser
	 * @throws Throwable
	 */
	//@Parameters({"BROWSER","URL"})
	@BeforeClass(groups = {"smokeTest","regTest"})
	public void launchTheBrowser(/*String BROWSER,String URL*/) throws Throwable
	{
		ENV_FILE_PATH = fLib.getFilePathFromPropertiesFile("projectConfigDataFilePath");
		String BROWSER = fLib.getDataFromProperties(ENV_FILE_PATH, "browser");
		String URL = fLib.getDataFromProperties(ENV_FILE_PATH, "url");
	//	String BROWSER = System.getProperty("browser");
	//	String URL = System.getProperty("url");

		switch (BROWSER) {
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
		default:
			driver=new ChromeDriver();
			break;
		}
		sdriver=driver;
		wLib.maximizeTheBrowswer(driver);
		driver.get(URL);
		wLib.waitForElementInDOM(driver);
		System.out.println("Browser is launched");
	}

	/**
	 * login to application
	 * @throws Throwable
	 */
	@BeforeMethod(groups = {"smokeTest","regTest"})
	public void loginToApplication() throws Throwable
	{
		TEST_SCRIPT_EXCEL_FILE_PATH =   fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");

		String USERNAME = fLib.getDataFromProperties(ENV_FILE_PATH, "username");
		String PASSWORd = fLib.getDataFromProperties(ENV_FILE_PATH, "password");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORd);

		System.out.println("successfully logged into application");
	}

	/**
	 * logout from application
	 */
	@AfterMethod(groups = {"smokeTest","regTest"})
	public void logoutFromApplication()
	{
		HomePage homePage = new HomePage(driver);
		homePage.signOut(wLib, driver);
		System.out.println("successfully loggedOut from application");
	}

	/**
	 * close the browser
	 */
	@AfterClass(groups = {"smokeTest","regTest"})
	public void closeTheBrowser()
	{
		driver.quit();
		System.out.println("Browser is closed");
	}

	/**
	 * close the database connection
	 * @throws SQLException
	 */
	@AfterSuite(groups = {"smokeTest","regTest"})
	public void closeDB() throws SQLException
	{
		dLib.closeDB();
		System.out.println("database connection is closed");
	}
}
