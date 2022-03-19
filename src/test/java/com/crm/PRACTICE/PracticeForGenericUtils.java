package com.crm.PRACTICE;

import org.testng.annotations.Test;

import GenericLibrary.ExcelFileUtility;
import GenericLibrary.JavaUtility;
import GenericLibrary.PropertyFileUtility;

public class PracticeForGenericUtils {
	
	@Test
	public void practice() throws Throwable
	{
		JavaUtility jLib = new JavaUtility();
		int ran = jLib.getRandomNumber();
		String dat = jLib.getSystemDateInFormat();
		String date = jLib.getSystemDate();
		System.out.println(ran + date);
		System.out.println(dat);
		
		PropertyFileUtility pLib = new PropertyFileUtility();
		String brows = pLib.readDataFromPropertyFile("browser");
		System.out.println(brows);
		
		ExcelFileUtility eLib = new ExcelFileUtility();
		String value = eLib.readDataFromExcel("Org", 3, 2);
		System.out.println(value);
	
	}

}
