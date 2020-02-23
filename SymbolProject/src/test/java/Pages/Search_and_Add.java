package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Helper.Utility;

public class Search_and_Add {
	WebDriver driver;
	public Search_and_Add(WebDriver Idriver){
		
		this.driver=Idriver;

}
	@FindBy(id="search_query_top") WebElement search;
	@FindBy(xpath="//button[@name='submit_search']") WebElement searchbutton;
	@FindBy(xpath="//img[@title='Printed Dress']") WebElement select;
	@FindBy(name="Submit") WebElement add;
	@FindBy(xpath="//a[@title='Proceed to checkout']") WebElement proceed;
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']") WebElement pro;
	@FindBy(name="processAddress") WebElement proccedtocheckout;
	@FindBy(id="uniform-cgv") WebElement checkoutto;
	@FindBy(name="processCarrier") WebElement checkout;
	@FindBy(xpath="//a[@title='Pay by check.']") WebElement paying;
	@FindBy(xpath="//button[@class='button btn btn-default button-medium']") WebElement confirm ;
	
	public void validatesearch(String A){
		Utility.waitforWebElement(driver, search).sendKeys(A);
			}
	public void validateclickbutton(){
		Utility.waitforWebElement(driver, searchbutton).click();
	}
	public void selectitem(){
		Utility.waitforWebElement(driver, select).click();
	}
	public void submititem(){
		Utility.waitforWebElement(driver,add).click();
		}
	public void proceed(){
		
		Utility.waitforWebElement(driver, proceed).click();
			}
	public void pros(){
		Utility.waitforWebElement(driver, pro).click();
	}
	public void proccedtocheckout(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", proccedtocheckout);
		
		Utility.waitforWebElement(driver, proccedtocheckout).click();
	}
	public void tik(){
		Utility.waitforWebElement(driver,checkoutto).click();
	}
	public void checkout(){
		Utility.waitforWebElement(driver, checkout).click();
			}
	public void pay(){
		Utility.waitforWebElement(driver, paying).click();
	}
	public void confirm(){
		Utility.waitforWebElement(driver, confirm).click();
	}
}
