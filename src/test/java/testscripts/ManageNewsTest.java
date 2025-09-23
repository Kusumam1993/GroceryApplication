package testscripts;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.Base;
import constant.Constants;
import page.HomePage;
import page.LoginPage;
import page.ManageNews;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base
{
	@Test
	public void verifyAUserisAbleTOAddNews() throws IOException
	{
		
	String  username=ExcelUtility.getStringData(0, 0,"LoginPage");//row/column/sheetname
	String password=ExcelUtility.getStringData(0, 1,"LoginPage");
	
	LoginPage login=new LoginPage(driver);//default constructor invoking
	login.enterUsernameOnUserNameField(username);
	login.enterPasswordOnPasswordField(password);
	login.clickOnLogin();
	
	HomePage home=new HomePage(driver);
	home.clickOnManageNewsTile();
	ManageNews news=new ManageNews(driver);
	news.clickOnTheNewNewsButton();
	String  newNews=ExcelUtility.getStringData(1, 0,"ManageNewsPage");
	news.enterNewsOnNewsField(newNews);
	news.clickOnSave();
	
	String actual=news.newsSaveAlertDisplay();
	String expected="Alert!";
	Assert.assertEquals(actual,expected,Constants.ADDNEWUSER); 
	
	}
	@Test
	public void verifyUserIsAbleTOSearchNews() throws IOException
	{
		String  username=ExcelUtility.getStringData(0, 0,"LoginPage");//row/column/sheetname
		String password=ExcelUtility.getStringData(0, 1,"LoginPage");
		
		LoginPage login=new LoginPage(driver);//default constructor invoking
		login.enterUsernameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnLogin();
		HomePage home=new HomePage(driver);
		home.clickOnManageNewsTile();
		ManageNews news=new ManageNews(driver);
		news.clickOnTheSearchNews();
		String  newNews=ExcelUtility.getStringData(1, 0,"ManageNewsPage");
		news.enterNewsFOrSearch(newNews);
		news.clickonTheSearchButton();
		
		String actual=news.newsSearchDataPresent();
		String expected="Hello, Selenium Test";
		Assert.assertEquals(actual, expected,Constants.SEARCH);
		
		
	}
	@Test
	public void verifyUserIsAbleToResetNewsField() throws IOException
	{
		String  username=ExcelUtility.getStringData(0, 0,"LoginPage");//row/column/sheetname
		String password=ExcelUtility.getStringData(0, 1,"LoginPage");
		
		LoginPage login=new LoginPage(driver);//default constructor invoking
		login.enterUsernameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnLogin();
		HomePage home=new HomePage(driver);
		home.clickOnManageNewsTile();
		ManageNews news=new ManageNews(driver);
		news.clickOnTheResetButton();
		boolean newsResetTablePageNum=news.resetButtonPagenumberDisplayed();
		
		Assert.assertTrue(newsResetTablePageNum, Constants.RESET);
	}

}
