package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	public WebDriver driver;
	private static Logger log= LogManager.getLogger(ValidateTitle.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializeDriver();
		
		 driver.get(prop.getProperty("url"));
	} 
	 
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username,String Password, String text) throws IOException
	{
		//driver= initializeDriver();
		
		 driver.get(prop.getProperty("url"));
		 
		 LandingPage l = new LandingPage(driver);
		 
		 l.getLogin().click();
		 
		 
		 LoginPage lp= new LoginPage(driver);
		 
		 lp.getemail().sendKeys(Username);
		
		 lp.getpassword().sendKeys(Password);
		 
		lp.clkLogin().click();
		                                         
		 log.info(text);              //System.out.println(text);

		
		//driver.close();
		
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object [][] data = new Object[2][3];
		data[0][0]= "abcd@mail.com";
		data[0][1]= "123456";
	    data[0][2]= "Reastricted user";
	    
		
		data[1][0]= "xyz@gmail.com";
		data[1][1]= "789456";
		data[1][2]= "non Reastricted user"; 
		
		return data;
	}
	
}
