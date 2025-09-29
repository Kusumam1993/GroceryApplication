package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constants;
import page.HomePage;
import page.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base
{
	HomePage homepage;
	
	@Test(description="User is able to Logout from HomePage")
	public void verifyUserisabletoLogout() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0,"LoginPage");//row/column/sheetname
		String password=ExcelUtility.getStringData(0, 1,"LoginPage");
		
		LoginPage login=new LoginPage(driver);//default constructor invoking
		login.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password);		
		homepage=login.clickOnLogin().clickOnAdminprofile();
		login=homepage.clickonLogout();
		boolean signinpresent=homepage.isDisplayedSignin();
		Assert.assertTrue(signinpresent,Constants.LOGOUTERROR);
		
		
	}

}
