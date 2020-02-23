package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Helper.BaseClass;

import Pages.Search_and_Add;
import Pages.automation_login;

public class AutomationTest extends BaseClass{
	automation_login automation;
	Search_and_Add search;
	
	@Test(description = "", priority=1)// test ng
	public void AutomationToAp(){
		automation = PageFactory.initElements(driver, automation_login.class);
		logger= reports.createTest("Login Test For AP");
		automation.validateHomePage();
		automation.validatesignin();
		automation.Emailaddress("mohamedhafoo851@gmail.com");
		automation.validatepassword("hafoo851");
		automation.clickonSendButton();
	}
	
	
	@Test(priority=2)
	public void searchtest(){
		search =PageFactory.initElements(driver,Search_and_Add.class);
		logger= reports.createTest("Login Test for search");
		search.validatesearch("dress");
		search.validateclickbutton();
		search.selectitem();
		search.submititem();
		search.proceed();
		search.pros();
		search.proccedtocheckout();
		search.tik();
		search.checkout();
		search.pay();
		search.confirm();
		
	}
}
