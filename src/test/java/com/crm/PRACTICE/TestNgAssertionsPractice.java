package com.crm.PRACTICE;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNgAssertionsPractice {
	
	@Test
	public void assertionPractice()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("this is test 1");
        sa.assertEquals(1, 0);
        System.out.println("passed");
        sa.assertEquals(true,false);
        System.out.println("skip");
        System.out.println("fail");
        System.out.println("test2");
        Assert.assertEquals(1, 0);
        sa.assertAll();
	}

}
