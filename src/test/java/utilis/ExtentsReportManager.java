package utilis;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//import org.apache.poi.hpsf.Date;
//public class ExtentsReportManager {
	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;

import testcases.Base_Class;

	    public class ExtentsReportManager implements ITestListener{
	    	
		public ExtentSparkReporter sparkreporter;
		public ExtentReports extentreports;
		public ExtentTest test;
		String repName;

		 public void onStart(ITestContext testContext)
		 {
			  /* SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
			   Date dt=new Date();
			   String currentdatetimestamp=df.format(dt);*/
			 
			   String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			   
			   repName="Test-Report-"  +timestamp+".html";
			   sparkreporter=new ExtentSparkReporter(".\\reports\\" + repName);
			   
			   sparkreporter.config().setDocumentTitle("Automation project");
			   sparkreporter.config().setReportName("functional testing");
			   sparkreporter.config().setTheme(Theme.DARK);
			   
			   extentreports =new ExtentReports();
			   extentreports.attachReporter(sparkreporter);
			   extentreports.setSystemInfo("Application","Opencart");
			   extentreports.setSystemInfo("Module","Admin");
			   extentreports.setSystemInfo("Sub Module", "Customers");
			   extentreports.setSystemInfo("Sukanya", System.getProperty("user.name"));
			   extentreports.setSystemInfo("Enviorment", "QA");
			   
			   String os=testContext.getCurrentXmlTest().getParameter("os");
			   extentreports.setSystemInfo("Operating System", os);
			   String browser=testContext.getCurrentXmlTest().getParameter("browser");
			   extentreports.setSystemInfo("Browser", browser);
			   
			   List<String>includedgroups=testContext.getCurrentXmlTest().getIncludedGroups();
			   if(!includedgroups.isEmpty())
			   {
				   extentreports.setSystemInfo("Groups",includedgroups.toString());
			   }
			  }

		 
		  public  void onTestSuccess(ITestResult result) {
		      test=extentreports.createTest(result.getTestClass().getName());
		      test.assignCategory(result.getMethod().getGroups());    //disply groups in reports
		      test.log(Status.PASS,result.getName()+"got successfully executed");
		  }
		  
		  public  void onTestFailure(ITestResult result) {
			    test=extentreports.createTest(result.getTestClass().getName());
			    test.assignCategory(result.getMethod().getGroups());
			    
			    test.log(Status.FAIL,result.getName()+"got failed");
			    test.log(Status.INFO,result.getThrowable().getMessage());
			    try {
			    String imgpath=new Base_Class().captureScreen(result.getName());
			    test.addScreenCaptureFromPath(imgpath);
			    
			  }catch(Exception e1)
			    {
				  e1.printStackTrace();
			    }

		  }
	     public void onTestSkipped(ITestResult result) {
	          test=extentreports.createTest(result.getTestClass().getName());
	          test.assignCategory(result.getMethod().getGroups());
	          test.log(Status.SKIP,result.getName()+"got skipped");
	          test.log(Status.INFO,result.getThrowable().getMessage());
	  }
	     
	     public void onFinish(ITestContext testcontext) {
	    	    extentreports.flush();
	    	    
	    	    String pathofExtentReports=System.getProperty("user.dir")+"\\reports\\"+repName;
	    	    File  extentreport=new File(pathofExtentReports);
	    	    try {
	    	    	Desktop.getDesktop().browse(extentreport.toURI());
	    	    }catch(IOException e)
	    	    {
	    	    	e.printStackTrace();
	    	    }
	    	  }
	}


