package com.crm.ContactTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
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
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

@Listeners(GenericLibrary.ListnerImplementationClass.class)

public class CreateContactTest extends BaseClass{
	
	@Test(retryAnalyzer = GenericLibrary.RetryAnalyserImplementation.class)
	public void createContactTest() throws Throwable
	{
		
		String lastName = eLib.readDataFromExcel("Contacts", 1, 2)+"_"+jLib.getRandomNumber();
		
		/*Step 4: navigate to contact and create conatct with mandatory fields*/
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLnk();
		Assert.fail();
		
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createNewContact(lastName);
		
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actHeader = cip.contactNameInfo();
		if(actHeader.contains(lastName))
		{
			System.out.println(actHeader+"----> contact created");
		}
		else
		{
			System.out.println("contact not created");
		}
		
	}

}
