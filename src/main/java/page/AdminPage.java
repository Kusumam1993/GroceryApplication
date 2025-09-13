package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminPage 
{
	public WebDriver driver;
	public AdminPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")private WebElement newUser;
public void clickonNewButton()
{
	newUser.click();
}
@FindBy(xpath ="//input[@id='username']")private WebElement username;
public void enterUsernameOnUserNameField()
{
	username.sendKeys("Omy");
}
@FindBy(xpath = "//input[@id='password']")private WebElement password;
public void enterPasswordOnPasswordField()
{
	password.sendKeys("Omy21");
}
@FindBy(xpath = "//select[@id='user_type']")private WebElement userType;



public void selectUserType()
{
	Select select=new Select(userType);
	select.selectByVisibleText("Admin");
	
	
}
@FindBy(xpath = "//button[ @name='Create']") private WebElement saveNewUser;
public void clickOnSaveButton()
{
	saveNewUser.click();
}
@FindBy(xpath = "//a[@onclick='click_button(2)']")private WebElement userSearch;
public void clickOnSearchUser()
{
	userSearch.click();
}
@FindBy(xpath = "//input[@id='un']")private WebElement searchUserName;
public void enterUserNameforSearch()
{
	searchUserName.sendKeys("Hazel");
	
}
@FindBy(xpath = "//select[@id='ut']")private WebElement searchUserType;
public void selectUserTypeforSearch()
{
	Select select=new Select(searchUserType);
	select.selectByVisibleText("Staff");
}
@FindBy(xpath = "//button[@value='sr']")private WebElement search;
public void searchNewUser()
{
	search.click();
}
@FindBy(xpath = "//i[@class='ace-icon fa fa-sync-alt']")private WebElement retest;
public void clickOnRetestButton()
{
	retest.click();
}
}
