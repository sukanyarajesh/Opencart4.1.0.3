package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_Page extends BasePage {
	//constructr
	//WebDriver driver;
	public Home_Page(WebDriver driver)
	{
		super(driver);
	}
	//locators
	
	@FindBy(xpath="(//span[normalize-space()='My Account'])[1]")
	WebElement myacnt;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement regstr;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement login;
	
	//Actions methods
	public void Clickmyaccnt()
	{
		myacnt.click();
	}
	public void Clickregstr()
	{
		regstr.click();
	}
	public void clicklogin()
	{
		login.click();
	}
	
}
