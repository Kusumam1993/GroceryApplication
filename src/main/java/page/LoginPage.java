package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	
		public WebDriver driver;
		//Constructor creation
		public LoginPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
				
		@FindBy(xpath = "//input[@name='username']") private WebElement username;
		
		public void enterUsernameOnUserNameField(String userNamevalue)
		{
			username.sendKeys(userNamevalue);
		}
		
		@FindBy(xpath = "//input[@name='password']")private WebElement password;
		
		public void enterPasswordOnPasswordField(String passwordValue)
		{
			password.sendKeys(passwordValue);
		}
		
		@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")private WebElement login;
		
		public void clickOnLogin()
		{
			login.click();
		}
		
		

}
