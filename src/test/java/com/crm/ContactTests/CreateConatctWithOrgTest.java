package com.crm.ContactTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericLibrary.BaseClass;
import GenericLibrary.ExcelFileUtility;
import GenericLibrary.JavaUtility;
import GenericLibrary.PropertyFileUtility;
import GenericLibrary.WebDriverUtility;
import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.CreateOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationInfoPage;
import ObjectRepository.OrganizationsPage;
@Listeners(GenericLibrary.ListnerImplementationClass.class)
public class CreateConatctWithOrgTest extends BaseClass{
	
	@Test
	public void createContactWithOrgTest() throws Throwable
	{
		
		String lastName = eLib.readDataFromExcel("Contacts", 4, 2)+"_"+jLib.getRandomNumber();
		String OrgName = eLib.readDataFromExcel("Contacts", 4, 3)+" "+jLib.getRandomNumber();	
		
		/*Step 4: Navigate to Organizations Link*/
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLnk();
		
		/*Step 5: click on create organization Lnk*/
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		
		/*Step 6: enter mandatory fields and save*/
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrg(OrgName);
		Assert.fail();
		
		/*Step 7:verify for orgaqnization*/
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String header = oip.OrgNameInfo();
		if(header.contains(OrgName))
		{
			System.out.println(header);
			System.out.println("org created");
		}
		else
		{
			System.out.println(header);
			System.out.println("Org not created");
		}
		
		/*step 8: navigate to contacts link*/
		hp.clickOnContactLnk();
		
	    ContactsPage cp = new ContactsPage(driver);
	    cp.clickOnCreateContactImg();
	    
	    CreateContactPage ccp = new CreateContactPage(driver);
	    ccp.createNewContact(driver, lastName, OrgName);
		
		/*Step 10: verfify for contact*/
	    ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.contactNameInfo();
		if(contactHeader.contains(lastName))
		{
			System.out.println(contactHeader +" contact created");
		}
		else
		{
			System.out.println("contact not created");
		}
	
		

		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
