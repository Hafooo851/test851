package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Helper.Utility;

public class automation_login {
	
	WebDriver driver;
	public automation_login(WebDriver Idriver){
		
		this.driver=Idriver;
	}
	
	@FindBy(xpath="//a[@class='login']") WebElement signin;
	@FindBy(id="email") WebElement emailadress;
	@FindBy(id="passwd") WebElement pword;
	@FindBy(xpath="//p[@class='submit']//span[1]") WebElement submitsignin;

      public void validateHomePage(){
	   Utility.ValidateContainsTitle(driver,"My Store");
      }
      public void validatesignin(){
    	  Utility.waitforWebElement(driver, submitsignin).click();;
      }
      public void Emailaddress(String mohamed){
     	 Utility.waitforWebElement(driver, emailadress).sendKeys(mohamed);
     	 
      }
      public void validatepassword(String hafoo){
    	  Utility.waitforWebElement(driver, pword).sendKeys(hafoo);
      }
      public void clickonSendButton(){
     	 Utility.waitforWebElement(driver, submitsignin).click();
      }
      }