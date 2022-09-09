package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateNavigationBar extends base{
	public WebDriver driver;
	private static Logger log= LogManager.getLogger(ValidateTitle.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializeDriver();
		
		 driver.get(prop.getProperty("url"));
	}
	 
	@Test
	public void basePageNavigation() throws IOException
	{
		
		 
		 LandingPage l = new LandingPage(driver);
	  Assert.assertTrue(l.getNavigationBar().isDisplayed());
	  log.info("Navigation bar is sucessfully displayed");
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
}
