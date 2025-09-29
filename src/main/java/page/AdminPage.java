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
public AdminPage clickonNewButton()
{
	newUser.click();
	return this;
}
@FindBy(xpath ="//input[@id='username']")private WebElement username;
public AdminPage enterUsernameOnUserNameField(String newusername)
{
	username.sendKeys(newusername);
	return this;
}
@FindBy(xpath = "//input[@id='password']")private WebElement password;
public AdminPage enterPasswordOnPasswordField(String newpassword)
{
	password.sendKeys(newpassword);
	return this;
}
@FindBy(xpath = "//select[@id='user_type']")private WebElement userType;

public AdminPage selectUserType(String newuserType)
{
	Select select=new Select(userType);
	select.selectByVisibleText(newuserType);
	return this;	
}
@FindBy(xpath = "//button[ @name='Create']") private WebElement saveNewUser;
public AdminPage clickOnSaveButton()
{
	saveNewUser.click();
	return this;
}
@FindBy(xpath = "//a[@onclick='click_button(2)']")private WebElement userSearch;
public AdminPage clickOnSearchUser()
{
	userSearch.click();
	return this;
}
@FindBy(xpath = "//input[@id='un']")private WebElement searchUserName;
public AdminPage enterUserNameforSearch(String searchName)
{
	searchUserName.sendKeys(searchName);
	return this;
	
}
@FindBy(xpath = "//select[@id='ut']")private WebElement searchUserType;
public AdminPage selectUserTypeforSearch(String searchUsertype)
{
	//Select select=new Select(searchUserType);
	//select.selectByVisibleText(searchUsertype);
	searchUserType.sendKeys(searchUsertype);
	return this;
}
@FindBy(xpath = "//button[@value='sr']")private WebElement search;
public AdminPage searchNewUser()
{
	search.click();
	return this;
}
@FindBy(xpath = "//i[@class='ace-icon fa fa-sync-alt']")private WebElement retest;
public AdminPage clickOnRetestButton()
{
	retest.click();
	return this;
}

//Assertion
@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")private WebElement newUserAlert;
public String savedAlertDisply()
{
	return newUserAlert.getText();	
}

@FindBy(xpath = "//a[@class='page-link']")private WebElement searchdata;

public boolean isDisplayPagelink()
{
	return searchdata.isDisplayed();
}

@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']") private  WebElement tableDisplay;
public boolean tableDisplayed()
{
	return tableDisplay.isDisplayed();
}
}
