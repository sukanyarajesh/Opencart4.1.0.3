package testcases;



import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Home_Page;
import pageobjects.Login_page;
import pageobjects.Myaccntpage;
import utilis.DataProviders;

public class TC003_loginDDT extends Base_Class {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void verify_loginddt(String email, String pass, String exp) {

        logger.info("**** TC003 started *****");

        try {

            Home_Page hpage = new Home_Page(driver);
            hpage.Clickmyaccnt();
            hpage.clicklogin();

            Login_page lpage = new Login_page(driver);
            lpage.myemail(email);        
            lpage.mypasswd(pass);        
            lpage.clickmylogin();

            Myaccntpage myacnt = new Myaccntpage(driver);
            boolean status = myacnt.myacntpag();

          
            if (exp.equalsIgnoreCase("valid")) {

                if (status == true) {
                    myacnt.Clicklogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }

           
            else if (exp.equalsIgnoreCase("invalid")) {

                if (status == true) {
                    myacnt.Clicklogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }

        } catch (Exception e) {
            Assert.fail("Exception occurred: " + e.getMessage());
        }

        logger.info("**** TC003 finished *****");
    }
}

	 

