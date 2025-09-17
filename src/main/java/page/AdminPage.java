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
public void enterUsernameOnUserNameField(String newusername)
{
	username.sendKeys(newusername);
}
@FindBy(xpath = "//input[@id='password']")private WebElement password;
public void enterPasswordOnPasswordField(String newpassword)
{
	password.sendKeys(newpassword);
}
@FindBy(xpath = "//select[@id='user_type']")private WebElement userType;



public void selectUserType(String newuserType)
{
	Select select=new Select(userType);
	select.selectByVisibleText(newuserType);
	
	
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
public void selectUserTypeforSearch(String searchUsertype)
{
	Select select=new Select(searchUserType);
	select.selectByVisibleText(searchUsertype);
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

//Assertion
@FindBy(xpath = "//div[@class=\'alert alert-success alert-dismissible\']")private WebElement newUserAlert;
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
