package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Home_Page;
import pageobjects.Reg_AcntCls;

public class TC001_AcontRegistratin extends Base_Class {
	
	@Test(groups={"Master","Regression"})
	public void testcase()
	    {
		
	    logger.info("**** TC001_AccontRegistratin started****");
		Home_Page hp=new Home_Page(driver);
		hp.Clickmyaccnt();
		hp.Clickregstr();
		 logger.info("cliked on my accunt ....");
		 Reg_AcntCls Rac=new Reg_AcntCls (driver);
		 
		// Reg_AcntCls  Rac=new Reg_AcntCls(driver);
		 logger.info("provaiding customer details...");
		 try {
		 Rac.setFirstName(randomString());
		 Rac.setLastName(randomString());
		 Rac.setemail(randomString()+"@gmail.com");
		 Rac.setteleohone(randomNuemeric());
		 
		 String passwd=AlphaNuemaeric();
		 
		 Rac.setPasswd(passwd);
		 Rac.setconfrmpswd(passwd);
		 logger.info("entered the valid password");
		 Rac.clickPolicy();
		 Rac.Clickcon();
		 String confrm=Rac.Conformationmsg();
		 Assert.assertEquals(confrm,"Your Account Has Been Created!");
		 if(confrm.equals("Your Account Has Been Created!!!!"))
		 {
		 Assert.assertTrue(true);
		 }
		 else
		 {
			 logger.error("Test failed");
			 logger.debug("debug log...");
			 Assert.assertFalse(false);
			  
		   }
	    }
		 catch(Exception e) {
			 Assert.fail("Test got failed");
		 }
			logger.info("****TC001_AccontRegistratin finished....***"); 
		 }
		
		 
		
	  }
  
		
	


