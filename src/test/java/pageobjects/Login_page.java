package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_page extends BasePage{
     public Login_page(WebDriver driver)
	{
		super(driver);
	}
 //locators
     

@FindBy(xpath="//input[@id='input-email']")
WebElement email;
@FindBy(xpath="//input[@id='input-password']")
WebElement passwd;
@FindBy(xpath="//input[@value='Login']")
WebElement loginbutton;

//action methods
public void myemail(String mailid)
{
	email.sendKeys(mailid);
	
}
public void mypasswd(String validpasswd)
{
	
	passwd.sendKeys(validpasswd);
	
}
public void clickmylogin()
{
	loginbutton.click();
}


}
