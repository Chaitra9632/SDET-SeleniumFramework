package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibrary.WebDriverUtility;
public class CreateContactPage extends WebDriverUtility{
	
	//Step 1: Declaration
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement orgNameLookUpImg;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	//initialization
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgNameLookUpImg() {
		return orgNameLookUpImg;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Library
	/**
	 * This method will create new contact
	 * @param lastName
	 */
	public void createNewContact(String lastName) 
	{
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
	/**
	 * This method will create New Contact with leadsource drop down
	 * @param lastName
	 * @param leadSource
	 */
	public void createNewContact(String lastName, String leadSource)
	{
		lastNameEdt.sendKeys(lastName);
		select(leadSource, leadSourceDropDown);
		saveBtn.click();
	}
	
	/**
	 * this method will create new contactb with organization name
	 * @param driver
	 * @param lastName
	 * @param orgName
	 */
	public void createNewContact(WebDriver driver,String lastName, String orgName)
	{
		lastNameEdt.sendKeys(lastName);
		orgNameLookUpImg.click();
		switchToWindow(driver, "Accounts");
		searchEdt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
