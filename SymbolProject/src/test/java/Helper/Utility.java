package Helper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;




public class Utility {

		// alerts , handle up the price, verify 
		public static  WebElement waitforWebElement(WebDriver driver , By element)
		{  // you setup time for web driver 
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));//we enitialize 
			wait.until(ExpectedConditions.elementToBeClickable(element));// make sure is clicable
			return driver.findElement(element);
		}
		public static  WebElement waitforWebElement(WebDriver driver , WebElement element)
		{
			
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return element;
			
	}
		public static void validateMessage (WebElement element, String msg)// static mean not to be change
		
		{ //credit line approved "   "credit line approve
		Assert.assertEquals(element.getText(), msg);//equal get text and message
		}
		public static void ValidatePartialText(WebElement element, String msg)
		{
			Assert.assertTrue(element.getText().contains(msg));
			
		}
		public static void ValidateTitle(WebDriver driver, String title)
		{
	      boolean status=new WebDriverWait(driver, 30).until(ExpectedConditions.titleIs(title));
	      Assert.assertFalse(status);
	      }
		public static void ValidateContainsTitle(WebDriver driver, String title)
		{
		boolean status = new WebDriverWait(driver,30).until(ExpectedConditions.titleContains(title));
		   Assert.assertTrue(status);
		}
		public static void VerifyCurrentURL(WebDriver driver, String url)
        {         
		boolean status =new WebDriverWait(driver, 30).until(ExpectedConditions.urlContains(url));
		Assert.assertTrue(status);
        }
		public void dismissAlert(WebDriver driver)
		{
		new WebDriverWait (driver, 30).until(ExpectedConditions.alertIsPresent()).dismiss();
		}
	 public void AcceptAlert(WebDriver driver )
		{
			new WebDriverWait (driver , 30).until(ExpectedConditions.alertIsPresent()).accept();
		}
		public static void VerifyAcceptAlertMsg(WebDriver driver)
		{
		   String expected= new WebDriverWait(driver , 30).until(ExpectedConditions.alertIsPresent()).getText();
		   System.out.println(expected);
		   String actual="";
		   Assert.assertEquals(actual, expected);
		}
		public void handleFrame(WebDriver driver, int index)
			{
			new WebDriverWait(driver , 30).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
			}
		public static String captureScreenShot(WebDriver driver)
		{
			String time = getTime();
			String dest = System.getProperty("user.dir")+"/Screenshots/AP"+time+".png";// creat obj to hold screenshot
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);// the image will be file
		
		try{
			FileHandler.copy(src, new File(dest));// 
		}catch (IOException e){
			System.out.println("screenshot faild"+e.getMessage());
		}
		return dest;
		}
		public static String getTime()
		{
			DateFormat dateformat=new SimpleDateFormat("hh_mm_ss_dd_MM_YYY");
			return dateformat.format(new Date());
			
			
		}
				
}	
		
	
			
			
			
					
        		
			







