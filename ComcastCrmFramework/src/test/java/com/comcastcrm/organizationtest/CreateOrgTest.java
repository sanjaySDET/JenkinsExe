package com.comcastcrm.organizationtest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.VtigerObjectRepsitory.CreateOrganisationPage;
import com.comcast.VtigerObjectRepsitory.HomePage;
import com.comcast.VtigerObjectRepsitory.OrganisationsInfoPage;
import com.comcast.VtigerObjectRepsitory.VerifyOrganisationPage;
import com.comcast.genericutlity.BaseClass;

@Listeners(com.comcast.genericutlity.ListnerImplementation.class)
public class CreateOrgTest extends BaseClass{
	
	//sanjay
	@Test(retryAnalyzer = com.comcast.genericutlity.RetryImplementation.class)
	public void createOrgTest() throws Throwable{ 
		/*test script data*/
		int randomNum = jLib.getRandomNumber();
		
		String orgName = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "org", "tc_01", "organizationName")+randomNum;
		
		/*step 2 : navigate to Org page*/		
		HomePage homePage = new HomePage(driver);
		homePage.orgLink();
		
		/*step 3 :  navigate to create Org page*/
		OrganisationsInfoPage organisationsInfoPage = new OrganisationsInfoPage(driver);
		organisationsInfoPage.orgLookUpImg();
		
		/*step 4 :  create a new org*/		
		CreateOrganisationPage createOrganisationPage = new CreateOrganisationPage(driver);
		createOrganisationPage.enterOrgNameAndSave(orgName);
		
		 /*verify expected result*/
		VerifyOrganisationPage verifyOrganisationPage = new VerifyOrganisationPage(driver);
		String actHeader = verifyOrganisationPage.createdOrgName();
		Assert.assertTrue(actHeader.contains(orgName),orgName+ "is not verified FAIL");
        
		Reporter.log(orgName+ "is verified PASS",true); 
		//test script is completed
	}
}
