package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Helper.Utility;

public class Search {
	
	WebDriver driver;
	public Search(WebDriver Idriver){
		
		this.driver=Idriver;
}
	@FindBy(xpath="//input[@id='search_query_top']") WebElement Look;
    
	
	public void validateHomePage(){
		Utility.ValidateContainsTitle(driver,"My Store");
	}
	
	
}