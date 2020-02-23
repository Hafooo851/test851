package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DataProviderFactory.dataproviderfactory;
import Helper.BaseClass;
import Pages.LogOut;
import Pages.Login;

public class LoginTestWithDataProvider extends BaseClass {
Login login;
LogOut logout;

@Test(dataProvider="LoginData")
public void loginToAP(String uname, String pass)
{
	login = PageFactory.initElements(driver, Login.class);
	logger = reports.createTest("Login Test Fpr AP");
	login.validateHomePage();
	logger.pass("Home page validated");
	login.enterUserName(uname);
	logger.info("username entered");
	login.enterPassword(pass);
	logger.info("password entered");
	login.clickonLoginButton();
	logger.info("clicked on login button");
	}

   @DataProvider(name="LoginData")
  public Object[][] getDataFromSources()
  {System.out.println("LOG INFO: Running Data Provider First to generate the data ");
   int row=dataproviderfactory.getExcel().getRows("LoginData");
   System.out.println("Total rows in Excel"+row);
  Object[][]arr=new Object[row-1][2];// start with 0//two demention array
for (int i=0;i<row-1;i++)
{
	arr[i][0]=dataproviderfactory.getExcel().getCellData("LoginData", i+1, 0);
	arr[i][1]=dataproviderfactory.getExcel().getCellData("LoginData", i+1, 1);
	}
System.out.println("LOG:INFO-DATA Provider Is ready for usage");
return arr;

}
}