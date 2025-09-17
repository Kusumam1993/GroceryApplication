package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import page.AdminPage;
import page.HomePage;
import page.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;


public class AdminUserTest extends Base
{
	@Test
	public void VerifyWhetherAdminUserisabletoAddNewUser() throws IOException
	{
	String  username=ExcelUtility.getStringData(0, 0,"LoginPage");//row/column/sheetname
	String password=ExcelUtility.getStringData(0, 1,"LoginPage");
	
	LoginPage login=new LoginPage(driver);//default constructor invoking
	login.enterUsernameOnUserNameField(username);
	login.enterPasswordOnPasswordField(password);
	login.clickOnLogin();
	
	HomePage home=new HomePage(driver);
	home.clickOnAdminUserTile();//Home Page Tile is Admin user
	
	AdminPage adminuser=new AdminPage(driver);
	
	RandomDataUtility randomdata=new RandomDataUtility();
	String newusername=randomdata.randomUserName();
	String newpassword=randomdata.randomPassword();
	
	adminuser.clickonNewButton();
	adminuser.enterUsernameOnUserNameField(newusername);
	adminuser.enterPasswordOnPasswordField(newpassword);
	String  userType=ExcelUtility.getStringData(3, 0,"UserTypePage");
	adminuser.selectUserType(userType);
	adminuser.clickOnSaveButton();
	String actual=adminuser.savedAlertDisply();
	String expected="User Created Successfully";
	Assert.assertEquals(actual, expected,"AdminUser can't add a new user");
	}
	@Test
	public void verifyUserisAbleToSearchAnewlyAddedUser() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0,"LoginPage");//row/column/sheetname
		String password=ExcelUtility.getStringData(0, 1,"LoginPage");
		
		LoginPage login=new LoginPage(driver);//default constructor invoking
		login.enterUsernameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnLogin();
		
		HomePage home=new HomePage(driver);
		home.clickOnAdminUserTile();
		
		AdminPage adminuser=new AdminPage(driver);		
		adminuser.clickOnSearchUser();
		adminuser.enterUserNameforSearch();
		boolean pagenumber=adminuser.isDisplayPagelink();//for Assertion
		String  userType=ExcelUtility.getStringData(1, 0,"UserTypePage");
		
		adminuser.selectUserTypeforSearch(userType);
		adminuser.searchNewUser();
		Assert.assertTrue(pagenumber, "User not able to view search data");
		
		
		
	}
	@Test
	public void verifyUserisAbleToResetANewlyAddedUser() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0,"LoginPage");//row/column/sheetname
		String password=ExcelUtility.getStringData(0, 1,"LoginPage");
		
		LoginPage login=new LoginPage(driver);//default constructor invoking
		login.enterUsernameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnLogin();
		
		HomePage home=new HomePage(driver);
		home.clickOnAdminUserTile();
		
		AdminPage adminuser=new AdminPage(driver);	
		adminuser.clickOnRetestButton();
		boolean tablepresent=adminuser.tableDisplayed();
		Assert.assertTrue(tablepresent, "User not able to Refresh the page");
		
		
	}
	
	
	
	
	

}
