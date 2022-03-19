package com.crm.GenericLibrary;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;
import com.mysql.cj.jdbc.Driver;

public class ListnerImplementationClass implements ITestListener 
{ 
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		
		
	}

	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, result.getMethod().getMethodName()+"--->passed");
		
		
	}

	public void onTestFailure(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName()+"-";
		test.log(Status.FAIL, MethodName+"-----failed");
		
		//Step 1: Configure screenshot name
		String screenshotName = MethodName+new JavaUtility().getSystemDateInFormat();
		System.out.println(screenshotName);
		
		//Step 2: using screenshot method from webDriver Utility
		try {
			//new WebDriverUtility().getScreenShot(BaseClass.sDriver, screenshotName);
			EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
			File src = eDriver.getScreenshotAs(OutputType.FILE);
			//String pa = System.getProperty("user.dir")+"/ScreenShots/"+screenshotName+".PNG";
			String path = "./Screenshots/"+screenshotName+".png";
			File dst = new File(path);
			Files.copy(src, dst);

		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(screenshotName);
		
	}
	   
	

	
	
	public void onTestSkipped(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"---->skipped");
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
	
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReports/report"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("SDET Execution Reports");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Url", "https://localhost:8888");
		report.setSystemInfo("Platform", "Winodws10");
		report.setSystemInfo("Reporter Name", "Chaitra");
		
	}

	public void onFinish(ITestContext context) {
		
		report.flush();
		
	}
	
	

}
