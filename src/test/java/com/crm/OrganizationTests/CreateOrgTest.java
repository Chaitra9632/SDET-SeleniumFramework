package com.crm.OrganizationTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibrary.BaseClass;
import ObjectRepository.CreateOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.OrganizationInfoPage;
import ObjectRepository.OrganizationsPage;

@Listeners(GenericLibrary.ListnerImplementationClass.class)
public class CreateOrgTest extends BaseClass {
	
	@Test(groups = "smokeSuite")
	public void createOrgTest() throws Throwable
	{
		SoftAssert sa = new SoftAssert();

		String OrgName = eLib.readDataFromExcel("Org", 1, 2)+"_"+jLib.getRandomNumber();
		
		/*Step 4: Navigate to Organizations Link*/
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLnk();
		String ExpData = "Organizations";
		String actData = driver.findElement(By.linkText("Organizations")).getText();
		Assert.assertEquals(actData, ExpData);
		Assert.fail();
		
		/*Step 5: click on create organization btn*/
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		String expHeader = "Creating New Organizationswer";
		String actHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		sa.assertEquals(actHeader,expHeader);
		
		
		/*Step 6: enter mandatory fields and save*/
		CreateOrganizationPage cop= new CreateOrganizationPage(driver);
		cop.createNewOrg(OrgName);
		
		/*Step 7: verification*/
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.OrgNameInfo();
		Assert.assertTrue(actOrgName.contains(OrgName));
		Reporter.log(actOrgName +"org created", true);
		
		sa.assertTrue(actOrgName.contains("abc"));
		System.out.println("pass");
		sa.assertAll("all OK");
		


	}

}
