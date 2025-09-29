package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage 
{
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@onclick='click_button(1)']")private WebElement newNews;
	public ManageNewsPage clickOnTheNewNewsButton()
	{
		newNews.click();
		return this;
	}
	@FindBy(xpath = "//textarea[@name='news']") private WebElement newstext;
	
	public ManageNewsPage enterNewsOnNewsField(String freshNews)
	{
		newstext.sendKeys(freshNews);
		return this;
	}
	@FindBy(xpath = "//button[@class='btn btn-danger']") private WebElement savenews;
	public ManageNewsPage clickOnSave()
	{
		savenews.click();
		return this;
	}
	@FindBy(xpath = "//a[@href='javascript:void(0)']") private WebElement newsSearch;
	public ManageNewsPage clickOnTheSearchNews()
	{
		newsSearch.click();
		return this;
	}

	@FindBy(xpath = "//input[@name='un']")private WebElement newsText;
	public ManageNewsPage enterNewsFOrSearch(String searchNews)
	{
		newsText.sendKeys(searchNews);
		return this;
	}
	@FindBy(xpath = "//button[@name='Search']")private WebElement searchbutton;
	public ManageNewsPage clickonTheSearchButton()
	{
		searchbutton.click();
		return this;
	}
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")private WebElement newsReset;
	public ManageNewsPage clickOnTheResetButton()
	{
		newsReset.click();
		return this;
	}

//Assertion
@FindBy(xpath = "//h5[text()=' Alert!']") private WebElement newssaveAlert;
public String newsSaveAlertDisplay()
{	
	return newssaveAlert.getText();
	
}
@FindBy(xpath ="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")private WebElement newsSearchDataTable;
public String newsSearchDataPresent()
{
	return newsSearchDataTable.getText();
}
@FindBy(xpath = "//input[@name='un']")private WebElement getnewsText;
public String enterNewsFOrSearch()
{
return	getnewsText.getText();	
}

@FindBy(xpath = "//h4[text()='Search Manage News']") private WebElement textNewsInformationIsDisplayed;
public boolean isDisplayednewsInformation()
{
	return textNewsInformationIsDisplayed.isDisplayed();
}

@FindBy(xpath = "//h4[text()='Manage News']")private WebElement newsTableText;
public String resetTableTextIsDisplayed()
{
	return newsTableText.getText();
}
}
