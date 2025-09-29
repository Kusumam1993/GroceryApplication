package automationcore;



import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenshotUtiliy;

public class Base
{
	Properties prop;
	FileInputStream fs;
	
	public WebDriver driver;
	
	
	@Parameters("browsers")
	@BeforeMethod(alwaysRun = true)
	//browser initialization
		public void initializeBrowser(String browsers) throws Exception
		{
		prop=new Properties();
		fs=new FileInputStream(Constants.CONFIGPATH);
		prop.load(fs);
		
		if (browsers.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver(); //actually creates the driver/browser object. ChromeDriver,FirefoxDriver,EdgeDriver - predefined driver class		    			
		}
		else if (browsers.equalsIgnoreCase("Firefox")) 
		{
			driver = new FirefoxDriver();
		}
		else if(browsers.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver();
		   
			driver = new EdgeDriver();
		}
		else
		{
			throw new Exception("Invalid Browser");
		}
			
			driver.get(prop.getProperty("url")); //launching the url in browser. In get method if the default value is null means - it is expecting a string value
			driver.manage().window().maximize();//to maximize the window
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//Duration Class 
		}
	
	@AfterMethod(alwaysRun = true)
	
	public void driverQuit(ITestResult iTestResult) throws IOException 
	{

		if (iTestResult.getStatus() == ITestResult.FAILURE) //pass/ skipp/iTestResult is a interface
		{
		ScreenshotUtiliy screenShot = new ScreenshotUtiliy();
		screenShot.getScreenshot(driver, iTestResult.getName());
		}
		//driver.quit();
		//public void browserClose()
		//{
			//driver.close();
			//driver.quit();
		//}

		}


}
