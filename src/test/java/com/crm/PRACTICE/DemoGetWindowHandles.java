package com.crm.PRACTICE;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoGetWindowHandles {
	
	@Test
	public void demo()
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		//System.out.println(driver.getWindowHandle());
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		System.out.println(driver.getWindowHandle());
		driver.findElement(By.name("accountname")).sendKeys("dfgvhjnkm");
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		Set<String>lst=driver.getWindowHandles();
		for(String s : lst)
		{
			System.out.println(s);
		}
	}

}
