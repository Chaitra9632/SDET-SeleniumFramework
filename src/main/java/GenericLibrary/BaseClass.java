package GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	//Create Object of all Utilities
	public DatabaseUtility dbLib = new DatabaseUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public JavaUtility jLib = new JavaUtility();
	public PropertyFileUtility pLib = new PropertyFileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sDriver;
	
	@BeforeSuite(groups = {"regressionSuite","smokeSuite"})
	public void connectDataBase() throws Throwable
	{
		//dbLib.connectToDb();
		Reporter.log("=====db connection successful=====",true);
	}
	
	@BeforeClass(groups = {"regressionSuite","smokeSuite"})
	//@Parameters("browser")
	//@BeforeTest
	public void launchTheBrowser() throws Throwable
	{
		//read data from property
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		
		//Create RunTime Polymorphism
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		sDriver = driver;
		
	    wLib.maximizeWindow(driver);
	    wLib.waitForPageLoad(driver);
	    driver.get(URL);
	    Reporter.log("=====browser launch successful====", true);
	    
	}
	
	@BeforeMethod(groups = {"regressionSuite","smokeSuite"})
	public void login() throws Throwable
	{
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("====login succesfull====",true);
	}
	
	@AfterMethod(groups = {"regressionSuite","smokeSuite"})
	public void logout()
	{
		HomePage hp = new HomePage(driver);
		hp.signOutOfApp(driver);
		Reporter.log("====logout successfull=====", true);
		
	}
	
	@AfterClass(groups = {"regressionSuite","smokeSuite"})
	//@AfterTest
	public void closeBrowser()
	{
		driver.quit();
		Reporter.log("=====browser close successful", true);
	}
	
	@AfterSuite(groups = {"regressionSuite","smokeSuite"})
	public void closeDb()
	{
		//dbLib.closeDB();
		Reporter.log("=====Database close successful====", true);
	}
	
	
	
	
	
	
	
	
	
	
	

}
