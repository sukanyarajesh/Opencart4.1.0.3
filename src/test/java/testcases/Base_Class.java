package testcases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;// log4jimports
import org.apache.logging.log4j.Logger;//log4jimports
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Base_Class  {
public	static WebDriver driver;
public	Logger logger;
public	Properties p;
	@BeforeClass(groups= {"Sanity","Master","Regression"})
    @Parameters({"os","browser"})
	 public void setup(String os,String br) throws 
IOException
	
	{
		
		 FileReader file=new FileReader("./src//test//resources//config.properties");
		 p=new Properties();
		// p.load(file);
		 p.load(file);
		 logger=LogManager.getLogger(this.getClass());
		 
		 if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		 {
			 DesiredCapabilities capabilities=new DesiredCapabilities();
			 //os
			 
			 if(os.equalsIgnoreCase("windows"))
			 {
				 capabilities.setPlatform(Platform.WIN11);
			 }
			 else if(os.equalsIgnoreCase("mac"))
			 {
				 capabilities.setPlatform(Platform.MAC);
			 }
			 else
			 {
				 System.out.println("not matching operating system");
				 return;
			 }
		  
			// br
			 switch(br.toLowerCase())
			 {
			 
			 case "chrome":capabilities.setBrowserName("chrome");break;
			 case " edge " :capabilities.setBrowserName("edge");break;
			 default:System.out.println("not matching browser");
			 
			 }
			 
			 driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		 }
		 if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		 {
			 
			 switch(br.toLowerCase())
			 {
			 case "chrome": driver=new ChromeDriver();break;
			 case "edge"  :driver=new EdgeDriver();break;
			 case "firefox":driver=new FirefoxDriver();break;
			 default: System.out.println("browser name are invalid");return;
			 }
			 
			 
			 
			 
		 }
		/* switch(br.toLowerCase())
		 {
		 case "chrome": driver=new ChromeDriver();break;
		 case "edge"  :driver=new EdgeDriver();break;
		 case "firefox":driver=new FirefoxDriver();break;
		 default: System.out.println("browser name are invalid");return;
		 }*/
		 
		 
	      //driver=new ChromeDriver();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get(p.getProperty("appURL"));
		 driver.manage().window().maximize();
		
	}
	@AfterClass(groups= {"sanity","regression"})
	public void teardown()
	{
		driver.quit();
	}
	 public String randomString()
		{
		    String randommailid=	RandomStringUtils.randomAlphabetic(5);
			return(randommailid);
		}
			
	   public String randomNuemeric()
	   {
		   String number=RandomStringUtils.randomNumeric(8);
		    return(number);
	   }
	  public String AlphaNuemaeric() 
	  {
		 String gennerateString=RandomStringUtils .randomAlphabetic(5);
		 String generateNumber=RandomStringUtils.randomNumeric(4);
		 String randomAlpha=gennerateString+"$"+generateNumber;
		 return randomAlpha;
		
		  
	  }
	  public String captureScreen(String tname)
	  {
		String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
		File sourcefile=takescreenshot.getScreenshotAs(OutputType.FILE);
		String targetfilepath=System.getProperty("user.dir")+"\\screenshots\\" +tname+"_"+timestamp+ ".png";
		File targetfile=new File(targetfilepath);
		sourcefile.renameTo(targetfile);
		
		return targetfilepath;
		
		  
	  }

}
