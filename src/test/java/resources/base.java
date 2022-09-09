package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

public class base {

	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		 prop=new Properties();
		
		FileInputStream fis=new FileInputStream("D:\\eclipse-java-2022-06-R-win32-x86_64\\E2EProject\\src\\test\\java\\resources\\data.properties");
		
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\suhas.tupake\\Desktop\\path\\chromedriver.exe");
		    driver=new ChromeDriver();
		}
		
		else if(browserName.equals("firefox"))
		{
			
			 System.setProperty("webdriver.gecko.driver", "pathToGeckoDriver + '\\geckodriver.exe' ");
			 WebDriver driver = new FirefoxDriver();
			
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "Path of IE file \\IEDriverServer.exe");
			WebDriver driver=new InternetExplorerDriver(); 
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	public void getScrenShotPath(String testcasename, WebDriver driver) throws IOException            // to take a screenshot of a test which is fail
	{
		/*TakesScreenshot ts = (TakesScreenshot)driver;
		
	       File source = ts.getScreenshotAs(OutputType.FILE);
	       
	       File dest = new File("C:\\Users\\suhas.tupake\\Desktop\\path\\scrrenshot.png");
	       FileHandler.copy(source, dest);*/
	       
	       // optional code for taking screenshot
	       TakesScreenshot tss = (TakesScreenshot)driver;
	       File sourcee = tss.getScreenshotAs(OutputType.FILE);
	       String destinationFile = System.getProperty("uesr.dir")+"\\reports"+testcasename+".png";
	       FileUtils.copyFile(sourcee,new  File(destinationFile));
		
	}
}
