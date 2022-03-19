package com.crm.PRACTICE;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PracticeTestNG {
	
	@Test(priority = 2)
	public void createOrg()
	{
		System.out.println("org created");
		//Reporter.log("Org Created - report"); //only in html report
	}
	
	@Test(dependsOnMethods = "createOrg",priority = 3)
	public void modifyOrg()
	{
		System.out.println("org modified");
		//Reporter.log("org Modified ---- report + console",true);//print statement in report n console
	}
	
	@Test(priority = 1)
	public void deleteOrg()
	{
		System.out.println("org deleted");
	}

}
