package TestCases;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Helper.BaseClass;
import Pages.Login;

public class LoginTest extends BaseClass {
	
	Login login;
	
	@Test(description = "", priority=1)
	public void loginToAP(){
		
		login = PageFactory.initElements(driver, Login.class);
		logger= reports.createTest("Login Test For AP");
        login.validateHomePage();
        logger.pass("Home Page Validate");
        login.enterUserName("Admin");
        logger.info("username entered");
        login.enterPassword("admin123");
        logger.info("password entered");
        login.clickonLoginButton();
        logger.info("Clicked on login button");
        
				
	}
}
