package com.comcast.genericutlity;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * 
 * @author SanjayBabu
 *
 */
public class JavaScriptUtility {

	JavascriptExecutor js;
	
	/**
	 * creating a constructor
	 * @param driver
	 */
	public JavaScriptUtility(WebDriver driver)
	{
		js=(JavascriptExecutor)driver;
	}
	/**
	 *  this method will scrollUp till the top of the page
	 */
	public void scrollUp()
	{
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	/**
	 * this method will scrollDown till the bottom of the page
	 */
	public void scrollDown()
	{
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	/**
	 * this method is used to scroll till the element in the page
	 * @param element
	 */
	public void scrollTillElement(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	/**
	 * this method is used to launch the URL of the application
	 * @param url
	 */
	public void launchApplication(String url)
	{
		js.executeScript("window.location=arguments[0]", url);
	}
	/**
	 * this method is used to pass the text to the textBox using sendKeys
	 * @param element
	 * @param data
	 */
	public void sendKeys(WebElement element,String data)
	{
		js.executeScript("arguments[0].value=arguments[1]",element,data);
	}
	/**
	 * this element is used to click on the particular element
	 * @param element
	 */
	public void click(WebElement element)
	{
		js.executeScript("arguments[0].click()", element);
	}
	/**
	 * this method is used to click on particular element using Id
	 * @param elementId
	 */
	public void clickElementByID(String elementId)
	{
		js.executeScript("document.getElementById('elementId').click()");
	}
	/**
	 * this method is used to fetch the text of particular element
	 * @param element
	 * @return
	 */
	public String getTheText(WebElement element)
	{
        String textFieldValue = (String) js.executeScript("return arguments[0].value;",element);
		return textFieldValue;
	}
	/**
	 * this method is used to fetch the currentURL Of The Application
	 * @return
	 */
	public String getUrlOfCurrentPage()
	{
		String url = (String) js.executeScript("return window.location.href");
		return url;
	}
	/**
	 * this method is used to fetch the currentTill Of The Application
	 * @return
	 */
	public String getTitleOfCurrentPage()
	{
		String title = (String) js.executeScript("return document.title");
		return title;
	}
}