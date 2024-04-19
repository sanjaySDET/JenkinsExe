package com.comcastcrm.organizationtest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.VtigerObjectRepsitory.CreateOrganisationPage;
import com.comcast.VtigerObjectRepsitory.HomePage;
import com.comcast.VtigerObjectRepsitory.OrganisationsInfoPage;
import com.comcast.VtigerObjectRepsitory.VerifyOrganisationPage;
import com.comcast.genericutlity.BaseClass;

@Listeners(com.comcast.genericutlity.ListnerImplementation.class)
public class CreateOrgWithPhoneNumber extends BaseClass{
	
	@Test(groups = {"regTest"},retryAnalyzer = com.comcast.genericutlity.RetryImplementation.class)
	public void createOrgWithMobileNum() throws Throwable {
		/*test script data*/
	   int randomNum = jLib.getRandomNumber();
	
	    String orgName = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "org", "tc_03", "organizationName") +"_"+ randomNum;
	    String phoneNumber = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "org", "tc_03", "phoneNumber") ;

		/*step 2 : navigate to Org page*/
		HomePage homePage = new HomePage(driver);
		homePage.getOrganisationLink().click();
		
		/*step 3 :  navigate to create Org page*/
		OrganisationsInfoPage organisationsInfoPage = new OrganisationsInfoPage(driver);
		organisationsInfoPage.orgLookUpImg();
		
		/*step 4 :  create a new org*/
		CreateOrganisationPage createOrganisationPage = new CreateOrganisationPage(driver);
		createOrganisationPage.enterOrgPhoneNoAndSave(orgName, phoneNumber);
		
	//	Assert.fail();
		 /*verify expected result*/
		SoftAssert asser = new SoftAssert();
		VerifyOrganisationPage verifyOrganisationPage = new VerifyOrganisationPage(driver);
		String actHeader = verifyOrganisationPage.createdOrgName();
		asser.assertTrue(actHeader.contains(orgName),orgName+"is not verified FAIL");
        Reporter.log(orgName+ "is verified PASS",true);
        
        String actPhoneNumber =  verifyOrganisationPage.createdPhNo();
        asser.assertTrue(actPhoneNumber.equals(phoneNumber),phoneNumber+ "is not verified FAIL");
        Reporter.log(phoneNumber+ "is verified PASS",true);
        
        asser.assertAll();
		//Finished
	}
}
