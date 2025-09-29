package testscripts;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.Base;
import constant.Constants;
import page.HomePage;
import page.LoginPage;
import page.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base
{
	//LoginPage login;
	HomePage home;
	ManageNewsPage news;
	@Test(priority=-1,description="User is able to add News")
	public void verifyAUserisAbleTOAddNews() throws IOException
	{
		
	String  username=ExcelUtility.getStringData(0, 0,"LoginPage");//row/column/sheetname
	String password=ExcelUtility.getStringData(0, 1,"LoginPage");
	LoginPage login=new LoginPage(driver);
	login.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password);
	home=login.clickOnLogin();
	String  newNews=ExcelUtility.getStringData(1, 0,"ManageNewsPage");
	news=home.clickOnManageNewsTile().clickOnTheNewNewsButton().enterNewsOnNewsField(newNews).clickOnSave();	
	String actual=news.newsSaveAlertDisplay();
	String expected="Alert!";
	Assert.assertEquals(actual,expected,Constants.ADDNEWNEWS); 	
	}
	@Test(priority=1,description="User is able to search for a newly added News")
	public void verifyUserIsAbleTOSearchNews() throws IOException
	{
		String  username=ExcelUtility.getStringData(0, 0,"LoginPage");//row/column/sheetname
		String password=ExcelUtility.getStringData(0, 1,"LoginPage");		
		LoginPage login=new LoginPage(driver);//default constructor invoking
		login.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password);
		home=login.clickOnLogin();
		String  newNews=ExcelUtility.getStringData(1, 0,"ManageNewsPage");
		news=home.clickOnManageNewsTile();
		news.clickOnTheSearchNews().enterNewsFOrSearch(newNews).clickonTheSearchButton();	
		String actual=news.newsSearchDataPresent();
		String expected="Tiger biscuits packet Damage";
		Assert.assertEquals(actual, expected,Constants.NEWSSEARCH);
		
		
	}
	@Test(priority=0,description="User is able to Reset News field")
	public void verifyUserIsAbleToResetNewsField() throws IOException
	{
		String  username=ExcelUtility.getStringData(0, 0,"LoginPage");//row/column/sheetname
		String password=ExcelUtility.getStringData(0, 1,"LoginPage");		
		LoginPage login=new LoginPage(driver);//default constructor invoking
		login.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password);
		home=login.clickOnLogin();		
		news=home.clickOnManageNewsTile();				
		news.clickOnTheSearchNews().clickOnTheResetButton();
		boolean informationDisplay=news.isDisplayednewsInformation();			
		Assert.assertFalse(informationDisplay, Constants.NEWSRESET);
	}

}
