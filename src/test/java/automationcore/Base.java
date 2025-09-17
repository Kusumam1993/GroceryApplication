package automationcore;



import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ScreenshotUtiliy;

public class Base {
	public WebDriver driver;
	//browser initialization
	@BeforeMethod
		public void initializeBrowser()
		{
			
			driver = new ChromeDriver(); //actually creates the driver/browser object. ChromeDriver,FirefoxDriver,EdgeDriver - predefined driver class
			//driver = new FirefoxDriver();
			//WebDriverManager.edgedriver();
		    
			//driver = new EdgeDriver();
			driver.get("https://groceryapp.uniqassosiates.com/admin/login"); //launching the url in browser. In get method if the default value is null means - it is expecting a string value
			driver.manage().window().maximize();//to maximize the window
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//Duration Class 
		}
	@AfterMethod
	public void driverQuit(ITestResult iTestResult) throws IOException 
	{

		if (iTestResult.getStatus() == ITestResult.FAILURE) //pass/ skipp/iTestResult is a interface
		{
		ScreenshotUtiliy screenShot = new ScreenshotUtiliy();
		screenShot.getScreenshot(driver, iTestResult.getName());
		}
		//driver.quit();

		}


}
