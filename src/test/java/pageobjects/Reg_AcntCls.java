package pageobjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reg_AcntCls extends BasePage {
	
	public Reg_AcntCls(WebDriver driver)
	{
		super(driver);
	}
	

@FindBy(xpath="//input[@id='input-firstname']")
WebElement firstname;
@FindBy(xpath="//input[@id='input-lastname']")
WebElement lastname;
@FindBy(xpath="//input[@id='input-email']")
WebElement email;
@FindBy(xpath="//input[@id='input-telephone']")
WebElement telephone;
@FindBy(xpath="//input[@id='input-password']")
WebElement password;
@FindBy(xpath="//input[@id='input-confirm']")
WebElement confrmpassword;
@FindBy(xpath="//input[@name='agree']")
WebElement ckPolicy;
@FindBy(xpath="//input[@value='Continue']")
WebElement clickcontinue;
//FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']");
@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement confrmmsg;

public void setFirstName(String Nme)
{
	firstname.sendKeys(Nme);
}
public void setLastName(String lstNme)
{
	lastname.sendKeys(lstNme);
}
public void setemail(String Mailid)
{
	email.sendKeys(Mailid);
}
public void setteleohone(String Telep)
{
	telephone.sendKeys(Telep);
}
public void setPasswd(String pswd)
{
	password.sendKeys(pswd);
}
public void setconfrmpswd(String conPswd)
{
	confrmpassword.sendKeys(conPswd);
	
}
public void clickPolicy()
{
	ckPolicy.click();
}
public void Clickcon()
{
	clickcontinue.click();
	

//the click button some time not work properly we use another methods
// JavascriptExecutor jst=(JavascriptExecutor)driver;
//jst.executeScript("arguments[0].click;","clickcontinue");
// jst.executeScript("arguments[0].click;","clickcontinue");
 
// Actions act=new Actions(driver);
// act.moveToElement(clickcontinue).click().perform();
	
//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//wait.until(ExpectedConditions.elementToBeClickable(clickcontinue)).click();

	
 
}
public String Conformationmsg()
  {
	try {
	return(confrmmsg.getText());
	
	}
	catch(Exception e)
	{
		return (e.getMessage());
	
	
	
}

  }

}