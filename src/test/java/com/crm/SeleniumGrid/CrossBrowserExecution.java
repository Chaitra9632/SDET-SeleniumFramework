package com.crm.SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserExecution {
	
RemoteWebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void bcConfig(String Browser) throws MalformedURLException
	{
		URL url = new URL("http://18.188.121.22:4444/wd/hub");
		DesiredCapabilities cap = new DesiredCapabilities();
		
		if(Browser.equalsIgnoreCase("chrome"))
		{
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
		}
		
		driver = new RemoteWebDriver(url, cap);
	}
	
	
	@Test
	public void crossBrowser()
	{
		driver.get("https://gmail.com");
	}


}
