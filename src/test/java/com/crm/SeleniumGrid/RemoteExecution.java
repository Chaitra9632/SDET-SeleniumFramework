package com.crm.SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RemoteExecution {
	
	@Test
	public void remote() throws MalformedURLException
	{
		//store the remote url here
        URL url = new URL("http://18.188.121.22:4444/wd/hub");
        
        //set the capabilities
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.WINDOWS);
        
        //use remote webdriver to launch browser in remote machine
        RemoteWebDriver driver = new RemoteWebDriver(url, cap);
        
        //load gmail.com
        driver.get("https://gmail.com");
	}

}
