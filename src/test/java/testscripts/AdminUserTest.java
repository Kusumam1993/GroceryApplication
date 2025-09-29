package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constants;
import page.AdminPage;
import page.HomePage;
import page.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility; 


public class AdminUserTest extends Base
{
	HomePage homepage;
	AdminPage adminuser;
	@Test(priority=1,description="User is able to add a new user in Admin page")
	public void VerifyWhetherAdminUserisabletoAddNewUser() throws IOException
	{
	String  username=ExcelUtility.getStringData(0, 0,"LoginPage");//row/column/sheetname
	String password=ExcelUtility.getStringData(0, 1,"LoginPage");	
	LoginPage login=new LoginPage(driver);
	login.enterPasswordOnPasswordField(password).enterUsernameOnUserNameField(username);
	homepage=login.clickOnLogin();
	
	adminuser= homepage.clickOnAdminUserTile();//Home Page Tile is Admin user
	RandomDataUtility randomdata=new RandomDataUtility();
	String newusername=randomdata.randomUserName();
	String newpassword=randomdata.randomPassword();
	String  userType=ExcelUtility.getStringData(3, 0,"UserTypePage");
	adminuser.clickonNewButton().enterUsernameOnUserNameField(newusername).enterPasswordOnPasswordField(newpassword).selectUserType(userType).clickOnSaveButton();
	String actual=adminuser.savedAlertDisply();
	Assert.assertTrue(actual.contains("User Created Successfully"),Constants.ADDNEWUSER);
	}
	
	@Test(priority=3,description="User is able to search a newly added user in Admin page")
	public void verifyUserisAbleToSearchAnewlyAddedUser() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0,"LoginPage");//row/column/sheetname
		String password=ExcelUtility.getStringData(0, 1,"LoginPage");		
		LoginPage login=new LoginPage(driver);
		login.enterPasswordOnPasswordField(password).enterUsernameOnUserNameField(username);
		homepage=login.clickOnLogin();
		String  userName=ExcelUtility.getStringData(0, 0,"UserNamePage");		
		String  userType=ExcelUtility.getStringData(0, 1,"UserNamePage");
		adminuser= homepage.clickOnAdminUserTile();
	    adminuser.clickOnSearchUser().enterUserNameforSearch(userName).selectUserTypeforSearch(userType).searchNewUser();
		boolean pagenumber=adminuser.isDisplayPagelink();//for Assertion
		Assert.assertTrue(pagenumber,Constants.SEARCH);
		
		
		
	}
	@Test(priority=2,description="User is able to reset a newly added user in Admin page")
	public void verifyUserisAbleToResetANewlyAddedUser() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0,"LoginPage");//row/column/sheetname
		String password=ExcelUtility.getStringData(0, 1,"LoginPage");		
		LoginPage login=new LoginPage(driver);
		login.enterPasswordOnPasswordField(password).enterUsernameOnUserNameField(username);
		homepage=login.clickOnLogin();	
		adminuser=homepage.clickOnAdminUserTile().clickOnRetestButton();
		boolean tablepresent=adminuser.tableDisplayed();
		Assert.assertTrue(tablepresent,Constants.RESET);
		
		
	}
	
	
	
	
	

}
