package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNews 
{
	public WebDriver driver;
	public ManageNews(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@onclick='click_button(1)']")private WebElement newNews;
	public void clickOnTheNewNewsButton()
	{
		newNews.click();
	}
	@FindBy(xpath = "//textarea[@name='news']") private WebElement newstext;
	
	public void enterNewsOnNewsField(String freshNews)
	{
		newstext.sendKeys(freshNews);
	}
@FindBy(xpath = "//button[@class='btn btn-danger']") private WebElement savenews;
public void clickOnSave()
{
	savenews.click();
}
@FindBy(xpath = "//a[@href='javascript:void(0)']") private WebElement newsSearch;
public void clickOnTheSearchNews()
{
	newsSearch.click();
}

@FindBy(xpath = "//input[@name='un']")private WebElement newsText;
public void enterNewsFOrSearch(String searchNews)
{
	newsText.sendKeys(searchNews);
}
@FindBy(xpath = "//button[@name='Search']")private WebElement searchbutton;
public void clickonTheSearchButton()
{
	searchbutton.click();
}
@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")private WebElement newsReset;
public void clickOnTheResetButton()
{
	newsReset.click();
}

//Assertion
@FindBy(xpath = "//h5[text()=' Alert!']") private WebElement newssaveAlert;
public String newsSaveAlertDisplay()
{
	
	return newssaveAlert.getText();
			
	
}
@FindBy(xpath ="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td")private WebElement newsSearchDataTable;
public String newsSearchDataPresent()
{
	return newsSearchDataTable.getText();
}
@FindBy(xpath = "//a[@href='http://groceryapp.uniqassosiates.com/admin/list-news?page_ad=1']")private WebElement pageNumber;
public boolean resetButtonPagenumberDisplayed()
{
	return pageNumber.isDisplayed();
}
}
