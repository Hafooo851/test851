package Helper;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import DataProviderFactory.dataproviderfactory;

public class BaseClass {
	// we are creating object so we can reference back to them 
	//instead of calling jar files every time 
	public WebDriver driver;
	public ExtentReports reports;
	public ExtentTest logger;
	
	@BeforeSuite
	public void SetupReport()
	{
		// 
	System.out.println("log info - before suit running - sitting up report");   // i want it to come as an html file 
	ExtentHtmlReporter reporter=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/AP "+Utility.getTime()+".html"));
		 //were calling this object (reports)
		 reports=new ExtentReports();
		 reports.attachReporter(reporter);
		 System.out.println("log info - after suit running - reports are  ready to use ");
	} 
		  @BeforeClass
		 public void SetupBrowser()
		  	  {
			  // were calling the driver first, all the url will be saved on dataproviderfactory
		         System.out.println("log:info: creating browser session ");
		         driver= BrowserFactories.startApplication(
				 dataproviderfactory.getCofig().getBrowser(),
				 dataproviderfactory.getCofig().getStagingURL());
		
		 
		 System.out.println("Log:INFO: Browser session created");
		 
		  }
		  @AfterMethod
		  public void appendReport(ITestResult result)// calling the depencec i testresult
		  {
			System.out.println(("Test Name "+result.getName()));// the name of class (login , logout)get the name of the file
			System.out.println("Log:INFO - After method running - generating test report");
			  int status=result.getStatus(); // 
			  if(status==ITestResult.SUCCESS)
			  {
			 try{
					  logger.pass("Test scenario passed ", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenShot(driver)).build());
			 }catch(IOException e)
				  {
				 System.out.println("Not able to attach Screenshot"+e.getMessage());
				  }
			 }
			 else if (status==ITestResult.FAILURE)
			    try{
			    	logger.fail("TestFaild" + result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenShot(driver)).build());// i would like to get everything by throwable
			}catch(IOException e){
					  System.out.println("not able to attac screenshot"+e.getMessage());
			}
			 else if (status==ITestResult.SKIP)
				{
					  logger.skip("Test Scenario Skipped");
			    }
				   reports.flush();
				    System.out.println("Log: INFO: After method executed - test result appended to ");
		    }
     @AfterClass
     public void closesessions()
    {
	System.out.println("LOG: INFO: Closing Browser Sessions");
	driver.quit();
	System.out.println("Log: INFO: Browser Session Closed");
	
}
}
