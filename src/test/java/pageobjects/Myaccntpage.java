package pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Myaccntpage extends BasePage{

 public Myaccntpage(WebDriver driver)
 {
	 super(driver);
 }
	
 @FindBy(xpath="//h2[normalize-space()='My Account']") //my account page heeading
 WebElement myacc;
 @FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") //added in stepno:6
 WebElement logout;
 
 //action method
 //public boolean myaccexist()
 
 public boolean myacntpag() 
 {
	 { 
			try
			{
			return(myacc.isDisplayed());
			}
			catch(Exception e)
			{
				return false;
			}
		}
 }
	public void Clicklogout()
	{
		logout.click();
	}
	
}
