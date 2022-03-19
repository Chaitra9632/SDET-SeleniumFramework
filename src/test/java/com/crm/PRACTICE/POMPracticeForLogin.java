package com.crm.PRACTICE;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(GenericLibrary.ListnerImplementationClass.class)
public class POMPracticeForLogin {
	
	@Test
	public void pomPractice()
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8888");
		
		LoginPage lp = new LoginPage(driver);
        lp.loginToApp("admin", "manager");
        
        HomePage hp = new HomePage(driver);
        hp.clickOnOrgLnk();
        Assert.fail();
        hp.signOutOfApp(driver);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
