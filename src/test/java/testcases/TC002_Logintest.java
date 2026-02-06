package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Home_Page;
import pageobjects.Login_page;
import pageobjects.Myaccntpage;

public class TC002_Logintest extends Base_Class{
	@Test(groups={"Sanity","Master"})
	public void loginvalidation()
	{
		logger.info("***TestcaseTC001_Logintest started*****");
		try {
		Home_Page hpage=new Home_Page(driver);
		hpage.Clickmyaccnt();
		hpage.clicklogin();
		
	    Login_page lpage=new Login_page(driver);
	    lpage.myemail(p.getProperty("email"));
	    lpage.mypasswd(p.getProperty("password"));
	    lpage.clickmylogin();
	    
	    //my account page
	    Myaccntpage myacnt=new  Myaccntpage(driver);
	    boolean status= myacnt.myacntpag();
	    Assert.assertEquals(status, true);
	    
		
		}
		catch(Exception e)
			{
			  Assert.fail();
			}
		logger.info("***TestcaseTC001_Logintest finied*****");
	   
	}
}
