package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class LoginPage
{
	
		public WebDriver driver;
		
		PageUtility pageUtil=new PageUtility();
		WaitUtility waitUtil=new WaitUtility();
		
		//Constructor creation
		public LoginPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
				
		@FindBy(xpath = "//input[@name='username']") private WebElement username;
		
		public LoginPage enterUsernameOnUserNameField(String userNamevalue)
		{
			username.sendKeys(userNamevalue);
			return this;
		}
		
		@FindBy(xpath = "//input[@name='password']")private WebElement password;
		
		public LoginPage enterPasswordOnPasswordField(String passwordValue)
		{
			password.sendKeys(passwordValue);
			return this;
		}
		@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")private WebElement login;
		
		public HomePage clickOnLogin()
		{
			login.click();
			return new HomePage(driver);
		}
		//Assertion
		@FindBy(xpath = "//p[text()='Dashboard']") private WebElement dashboard;
		
		public boolean dashboardisDisplayed()
		{
			return dashboard.isDisplayed();//dashboard displayed or not there-isDisplayed
		}
		
		@FindBy(xpath = "//b[text()='7rmart supermarket']") private WebElement loginPageTitle;
		
		public String getPageTitle()
		{
			return loginPageTitle.getText();
		}
		
		
		
		

}
