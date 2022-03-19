package com.crm.PurchaseOrderTests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatePurchaseOrderWithVendorAndContactTest {
	
	@Test
	public void createPurchaseOrderWithVendorContactTest()
	{
		//WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		//login to app
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		
		//create contact
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("Priyanka1");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//create vendor
		WebElement eleMore = driver.findElement(By.xpath("//a[text()='More']"));
		Actions act = new Actions(driver);
		act.moveToElement(eleMore).perform();
		driver.findElement(By.linkText("Vendors")).click();
		driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
		driver.findElement(By.name("vendorname")).sendKeys("TYSS");
		driver.findElement(By.id("email")).sendKeys("ty@gmail.com");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//create product
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys("Mobile");
		WebElement eleProductCat = driver.findElement(By.name("productcategory"));
		Select sel = new Select(eleProductCat);
		sel.selectByValue("Hardware");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//create purchase order with above fields
		driver.findElement(By.xpath("//a[.='More']")).click();
		driver.findElement(By.linkText("Purchase Order")).click();
		driver.findElement(By.xpath("//img[@alt='Create Purchase Order...']")).click();
		driver.findElement(By.name("subject")).sendKeys("MarketNow");
		
		driver.findElement(By.xpath("//input[@name='vendor_name']/following-sibling::img[@alt='Select']")).click();
		
		Set<String> window = driver.getWindowHandles();
		for(String win :window)
		{
			driver.switchTo().window(win);
		}
		
		driver.findElement(By.name("search_text")).sendKeys("TYSS");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[.='TYSS']")).click();
		
		Set<String> window1 = driver.getWindowHandles();
		for(String win :window1)
		{
			driver.switchTo().window(win);
		}
		
		driver.findElement(By.xpath("//input[@name='contact_name']/following-sibling::img[@alt='Select']")).click();
		
		Set<String> contWin = driver.getWindowHandles();
		for(String win1 : contWin)
		{
			driver.switchTo().window(win1);
		}
		
		driver.findElement(By.name("search_text")).sendKeys("Priyanka1");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[.=' Priyanka1']")).click();
		driver.switchTo().alert().accept();
		
		/*
		 * Set<String> window2 = driver.getWindowHandles(); for(String win :window2) {
		 * driver.switchTo().window(win); }
		 */
		
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//logout and close
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		act.moveToElement(element).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
	}

}
