package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.Base;
//import page.HomePage;
//import automationcore.Base;
import constant.Constants;
import page.HomePage;
import page.LoginPage;
import utilities.ExcelUtility;


	public class LoginTest extends Base
	{
		HomePage homepage;
		@Test(groups= {"smoke"},priority=1,description="User can login with valid username and valid password",retryAnalyzer = retry.Retry.class)
		
		public void verifyUserLoginWithValidCredentials() throws IOException
		{
			
			String username=ExcelUtility.getStringData(0, 0,"LoginPage");//row/column/sheetname
			String password=ExcelUtility.getStringData(0, 1,"LoginPage");
			
			LoginPage login=new LoginPage(driver);//default constructor invoking
			login.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password);//chaining of methods
			homepage= login.clickOnLogin();//chaining of classes
			boolean dashbordDisplay=login.dashboardisDisplayed();
			Assert.assertTrue(dashbordDisplay,Constants.VALIDCREDENTIALERROR);
						
		}
		@Test(groups= {"smoke"},priority=2,description="User can login with valid username and Invalid password",dataProvider="loginProvider")
		public void verifyUserLoginWithValidUsernameAndInvalidPassword(String username, String password) throws IOException
		{
			//String username=ExcelUtility.getStringData(1, 0,"LoginPage");
			//String password=ExcelUtility.getStringData(1, 1,"LoginPage");
			
			LoginPage login=new LoginPage(driver);//default constructor invoking
			login.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLogin();
			String actual=login.getPageTitle();
			String expected="7rmart supermarket";
			Assert.assertEquals(actual, expected,Constants.INVALIDCREDENTIALERROR);
				
		}
		@Test(groups= {"smoke"},priority=4,description="User can login with Invalid username and valid password")
		public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException
		{
			String username=ExcelUtility.getStringData(2, 0,"LoginPage");
			String password=ExcelUtility.getStringData(2, 1,"LoginPage");
			
			LoginPage login=new LoginPage(driver);//default constructor invoking
			login.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLogin();
			String actual=login.getPageTitle();
			String expected="7rmart supermarket";
			Assert.assertEquals(actual, expected,Constants.INVALIDCREDENTIALERROR);
				
				
		}
		@Test(groups= {"smoke"},priority=3,description="User can login with Invalid username and Invalid password")
		public void verifyUserLoginWithInvalidUsernameAndInvalidPassword() throws IOException
		{
			String username=ExcelUtility.getStringData(3, 0,"LoginPage");//row/column/sheetname
			String password=ExcelUtility.getStringData(3, 1,"LoginPage");
			
			LoginPage login=new LoginPage(driver);//default constructor invoking
			login.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLogin();
			String actual=login.getPageTitle();
			String expected="7rmart supermarket";
			Assert.assertEquals(actual, expected,Constants.INVALIDCREDENTIALERROR);
				
				
		}
		@Test(priority=6,description="User can login with blank username and blank password")
		public void verifyUserLoginWithBlankUsernameAndBlankPassword() throws IOException
		{
			//String username=ExcelUtility.getStringData(4, 0,"LoginPage");//row/column/sheetname
			//String password=ExcelUtility.getStringData(4, 1,"LoginPage");
			
			LoginPage login=new LoginPage(driver);//default constructor invoking
			//login.enterUsernameOnUserNameField(username);
			//login.enterPasswordOnPasswordField(password);
			login.clickOnLogin();
			String actual=login.getPageTitle();
			String expected="7rmart supermarket";
			Assert.assertEquals(actual, expected,Constants.INVALIDCREDENTIALERROR);
				
				
		}
		@DataProvider(name = "loginProvider")
		public Object[][] getDataFromDataProvider() throws IOException {

			return new Object[][] 
					{ 
				      new Object[] { "admin", "admin2" },
				      new Object[] { "admin123", "123" },
					// new Object[] {ExcelUtility.getStringData(3,
					// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
			};
		}

		
}
