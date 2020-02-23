package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Helper.Utility;

public class Contact {
	
	WebDriver driver;
	public Contact(WebDriver Idriver){
		
		this.driver=Idriver;
	}
	@FindBy(xpath="//div[@id='contact-link']//a[contains(text(),'Contact us')]") WebElement Contactus;
    @FindBy(id="id_contact") WebElement control;
    @FindBy(id="email") WebElement email;
    @FindBy(id="id_order") WebElement order;
    @FindBy(id="fileUpload") WebElement File;
    @FindBy(xpath="//span[contains(text(),'Send')]") WebElement send;
    @FindBy(id="message") WebElement text;
    
    public void validateHomePage(){
		Utility.ValidateContainsTitle(driver,"My Store");
	}
    public void clickonContactButton(){
		Utility.waitforWebElement(driver, Contactus).click();
		System.out.println("LOG:INFO CLICKED on Contact button");
		}
    
    public void SubjectHeading(String subject){
    	Select dropdown= new Select(control);
    	dropdown.selectByVisibleText(subject);
       }
     public void Emailaddress(String safa){
    	 Utility.waitforWebElement(driver, email).sendKeys(safa);
    	 
     }
     public void Orderreference(String hataan){
     Utility.waitforWebElement(driver, order).sendKeys(hataan);
     }
     public void AttachFile(){
    	 File.sendKeys("C:\\Users\\hybutalla\\Desktop\\SQL EXC\\Capture.PNG");
     }
     
     public void Message(String Mom){
    	 Utility.waitforWebElement(driver, text).sendKeys(Mom);
     }
     public void clickonSendButton(){
    	 Utility.waitforWebElement(driver, send).click();
 		System.out.println("LOG:INFO CLICKED on login button");
 		 
     }
			
		}


