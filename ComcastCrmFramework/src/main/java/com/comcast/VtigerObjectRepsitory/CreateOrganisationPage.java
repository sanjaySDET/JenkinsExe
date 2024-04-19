package com.comcast.VtigerObjectRepsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.genericutlity.WebActionUtility;

public class CreateOrganisationPage {

	//Declaretion
	@FindBy(name = "accountname")private WebElement organisationNameEdtTxt;
	
	@FindBy(id = "phone") private WebElement phoneNoEdtTxt;
	
	@FindBy(name = "industry")private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")private WebElement typeDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")private WebElement saveBtn;
	
	
	//Initialization
	public CreateOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getOrganisationNameEdtTxt() {
		return organisationNameEdtTxt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Libraries
	/**
	 * this method is used to enter organisation name and click on save on saveBtn;
	 * @param orgName
	 */
	public void enterOrgNameAndSave(String orgName)
	{
		organisationNameEdtTxt.sendKeys(orgName);
		saveBtn.click();
	}
	
	/**
	 * this method is used to enterOrgNamePhoneNo and save 
	 * @param orgName
	 * @param phNo
	 */
	public void enterOrgPhoneNoAndSave(String orgName,String phNo)
	{
		organisationNameEdtTxt.sendKeys(orgName);
		phoneNoEdtTxt.sendKeys(phNo);
		saveBtn.click();
	}
	
	/**
	 * this method is to enter organisation with type and industry 
	 * @param orgName
	 * @param wLib
	 * @param industry
	 * @param type
	 */
	public void enterOrgTypeAndIndustry(String orgName,WebActionUtility wLib,String industry,String type)
	{
		organisationNameEdtTxt.sendKeys(orgName);
		wLib.select(industryDropDown, industry);
		wLib.select(typeDropDown, type);
		saveBtn.click();
	}
}