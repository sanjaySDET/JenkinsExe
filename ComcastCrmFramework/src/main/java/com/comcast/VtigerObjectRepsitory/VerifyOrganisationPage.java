package com.comcast.VtigerObjectRepsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyOrganisationPage {

	//Declaretion
	@FindBy(className = "dvHeaderText")private WebElement createdOrg;
	
	@FindBy(id = "dtlview_Phone")private WebElement createdPhNo;
	
	@FindBy(id = "dtlview_Industry")private WebElement createdIdstry;
	
	@FindBy(id = "dtlview_Type")private WebElement createdType;
	
	//Initialization
	public VerifyOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//utilization
	public WebElement getCreatedOrg() {
		return createdOrg;
	}
	
	//Business Libraries
	/**
	 * get the created Organisation name and verify
	 */
	
	public String createdOrgName()
	{
		return createdOrg.getText();
	}
	
	/**
	 * get the created PhoneNo and verify
	 */
	public String createdPhNo()
	{
		return createdPhNo.getText();
	}
	
	/**
	 * get the created industry from industry dropdown
	 * @return
	 */
	public String createdIndustry()
	{
		return createdIdstry.getText();
	}
	
	/**
	 * get the created type from type dropdown
	 * @return
	 */
	public String createdType()
	{
		return createdType.getText();
	}
}