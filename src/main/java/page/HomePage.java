package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class HomePage
{
	WaitUtility waitutility=new WaitUtility();
	public WebDriver driver;
	//Constructor creation
	public HomePage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer' ]")private WebElement adminUsertile ;
	public AdminPage clickOnAdminUserTile()
	{
		adminUsertile.click();
		return new AdminPage(driver);
	}
	@FindBy(xpath = "//img[@class='img-circle']") private WebElement admin;
	public HomePage clickOnAdminprofile()
	{
		admin.click();
		return this;
	}
	@FindBy(xpath = "//a[@class='dropdown-item' and @href='https://groceryapp.uniqassosiates.com/admin/logout']")private WebElement logout;
		public LoginPage clickonLogout()
		{
			waitutility.waitForVisibility(logout);
			logout.click();
			return new LoginPage(driver);
		}
	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']")private WebElement managenews;
	public ManageNewsPage clickOnManageNewsTile()
	{
		managenews.click();
		return new ManageNewsPage(driver);
	}
		//Assertion
		@FindBy(xpath = "//button[text()='Sign In']")private WebElement signinPresent;
		public boolean isDisplayedSignin()
		{
			return  signinPresent.isDisplayed();
		}

}
