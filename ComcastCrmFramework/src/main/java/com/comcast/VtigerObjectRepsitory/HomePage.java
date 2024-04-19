package com.comcast.VtigerObjectRepsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.genericutlity.WebActionUtility;

public class HomePage {

	//Declaretion
	@FindBy(linkText = "Organizations")
	private WebElement organisationLink;
	
	@FindBy(linkText = "Contacts")private WebElement contactsLink;
	
	@FindBy(linkText = "Products")private WebElement productsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstrator;
	
	@FindBy(xpath = "//a[.='Sign Out']")private WebElement signoutLink;
	
	//Intialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//utilization
	public WebElement getOrganisationLink() {
		return organisationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getAdminstrator() {
		return adminstrator;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
	
	//Buisness libraries
	public void orgLink()
	{
		organisationLink.click();
	}
	
	public void signOut(WebActionUtility wLib,WebDriver driver)
	{
		wLib.mouseOverOnElement(driver, adminstrator);
		signoutLink.click();
	}
}