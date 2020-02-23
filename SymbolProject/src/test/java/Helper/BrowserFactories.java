package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactories {
	
	 
	 	  public static  WebDriver startApplication(String browser,String appurl)
		{
		  WebDriver driver = null;
			if(browser.equalsIgnoreCase("Chrome"))
		{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
				driver=new ChromeDriver();
		}
		//else if (browser.equalsIgnoreCase("firefox"))
			//{
				//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir", +"/Drivers/chromedriver.exe");
				//driver=new FirefoxDriver();
		//}
			else if (browser.equalsIgnoreCase("IE"))
			{
				driver=new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			driver.get(appurl);
			return driver;
			
		}
}



