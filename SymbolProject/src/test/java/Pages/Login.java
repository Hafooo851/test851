package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Helper.Utility;

public class Login {
		
		WebDriver driver;
		public Login(WebDriver Idriver){
			
			this.driver=Idriver;
	}
		
	//@FindBy(xpath="//a[contains(text(),'sign in')]") WebElement SignIn;
	//@FindBy(xpath="//*[@id='email']") WebElement email;
	//@FindBy(name="password") WebElement password;
	//@FindBy(id="SubmitLogin") WebElement Loginbutton;
		
		@FindBy(id="txtUsername") WebElement username;
	    @FindBy(id="txtPassword") WebElement password;
	    @FindBy(id="btnLogin") WebElement submit;
	    
	    
	public void validateHomePage(){
		Utility.ValidateContainsTitle(driver,"OrangeHRM");
	}
		/*public void clickonSignIn(){
		Utility.waitforWebElement(driver, SignIn).click();
		System.out.println("LOG:INFO CLicked on SignIn link");
		}*/
		public void enterUserName(String uname){
		System.out.println("Log:INFO Username entered");
		Utility.waitforWebElement(driver, username).sendKeys(uname);
		}
		public void enterPassword(String pass){
			System.out.println("LOG:INFO password entered");
		Utility.waitforWebElement(driver, password).sendKeys(pass);
		}
		public void clickonLoginButton(){
			Utility.waitforWebElement(driver, submit).click();
			System.out.println("LOG:INFO CLICKED on login button");
		}
		}
