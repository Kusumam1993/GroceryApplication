package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	public WebDriver driver;
	//Constructor creation
	public HomePage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer' ]")private WebElement adminUsertile ;
	public void clickOnAdminUserTile()
	{
		adminUsertile.click();
	}
	@FindBy(xpath = "//img[@class='img-circle']") private WebElement admin;
	public void clickOnAdminprofile()
	{
		admin.click();
	}
	@FindBy(xpath = "//a[@class='dropdown-item' and @href='https://groceryapp.uniqassosiates.com/admin/logout']")private WebElement logout;
		public void ClickonLogout()
		{
			logout.click();
		}
	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']")private WebElement managenews;
	public void clickOnManageNewsTile()
	{
		managenews.click();
	}
		//Assertion
		@FindBy(xpath = "//button[text()='Sign In']")private WebElement signinPresent;
		public boolean isDisplayedSignin()
		{
			return  signinPresent.isDisplayed();
		}

}
