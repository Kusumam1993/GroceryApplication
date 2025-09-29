package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility 
{
	private WebDriver driver;
	public static final int EXPLICITWAIT=5;
	
	  
    public void waitForClickable(WebElement element, WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    public void waitUntilElementSelected(WebElement element, WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }
    
    public void waitForVisibility(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
       
    public void waitUntilElementIsVisible(WebElement element, WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
        wait.until(ExpectedConditions.visibilityOf(element));   	
    }
    
    public void waitUntilElementIsINVisible(WebElement element, WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
        wait.until(ExpectedConditions.invisibilityOf(element));   	
    }
  


}
