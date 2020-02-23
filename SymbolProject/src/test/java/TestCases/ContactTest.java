package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Helper.BaseClass;
import Pages.Contact;

public class ContactTest extends BaseClass{
	
	Contact contact;
	
	@Test(description = "", priority=1)
	public void ContactToAP(){
		
		contact = PageFactory.initElements(driver, Contact.class);
		logger= reports.createTest("Login Test For AP");
		contact.validateHomePage();
		logger.pass("Home Page Validate");
		contact.clickonContactButton();
		contact.SubjectHeading("Customer service");
		contact.Emailaddress("safa@gmail.com");
		contact.Orderreference("order number 1");
        contact.AttachFile();
        contact.Message("my mom ");
        contact.clickonSendButton();
        
	}
}
