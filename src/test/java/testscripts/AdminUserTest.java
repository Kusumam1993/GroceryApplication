package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.Base;
import page.AdminPage;
import page.HomePage;
import page.LoginPage;
import utilities.ExcelUtility;


public class AdminUserTest extends Base
{
	@Test
	public void VerifyWhetherAdminUserisabletoAddNewUser() throws IOException
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
	adminuser.clickonNewButton();
	adminuser.enterUsernameOnUserNameField();
	adminuser.enterPasswordOnPasswordField();
	adminuser.selectUserType();
	adminuser.clickOnSaveButton();
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
		adminuser.selectUserTypeforSearch();
		adminuser.searchNewUser();
		
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
		
		
		
	}
	
	
	
	
	

}
