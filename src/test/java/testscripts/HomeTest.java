package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import page.HomePage;
import page.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base
{
	@Test
	public void verifyUserisabletoLogout() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0,"LoginPage");//row/column/sheetname
		String password=ExcelUtility.getStringData(0, 1,"LoginPage");
		
		LoginPage login=new LoginPage(driver);//default constructor invoking
		login.enterUsernameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnLogin();
		HomePage home=new HomePage(driver);
		home.clickOnAdminprofile();
		home.ClickonLogout();
		boolean signinpresent=home.isDisplayedSignin();
		Assert.assertTrue(signinpresent, "User can't logout from the application");
		
		
	}

}
