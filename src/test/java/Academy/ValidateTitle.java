package Academy;

import static org.testng.Assert.assertEquals;

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

public class ValidateTitle extends base{
	public WebDriver driver;
	private static Logger log= LogManager.getLogger(ValidateTitle.class.getName());
	
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializeDriver();
		log.info("Driver is initialized");
		
		 driver.get(prop.getProperty("url"));
		 
		 log.info("Navigated to Homepage");
	} 
	@Test
	public void basePageNavigation() throws IOException
	{
		
		 
		 LandingPage l = new LandingPage(driver);
		 //Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		 Assert.assertEquals(l.getTitle().getText(), "Featured courses");          //l.getTitle().getText();
		 log.info("Sucessfully validated text message");
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
