package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import automationcore.Base;

import page.LoginPage;
import utilities.ExcelUtility;


	public class LoginTest extends Base
	{
		@Test
		public void verifyUserLoginWithValidCredentials() throws IOException
		{
			String username=ExcelUtility.getStringData(0, 0,"LoginPage");//row/column/sheetname
			String password=ExcelUtility.getStringData(0, 1,"LoginPage");
			
			LoginPage login=new LoginPage(driver);//default constructor invoking
			login.enterUsernameOnUserNameField(username);
			login.enterPasswordOnPasswordField(password);
			login.clickOnLogin();
			boolean dashbordDisplay=login.dashboardisDisplayed();
			Assert.assertTrue(dashbordDisplay,"User could not login with valid credentials");
						
		}
		@Test
		public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException
		{
			String username=ExcelUtility.getStringData(1, 0,"LoginPage");
			String password=ExcelUtility.getStringData(1, 1,"LoginPage");
			
			LoginPage login=new LoginPage(driver);//default constructor invoking
			login.enterUsernameOnUserNameField(username);
			login.enterPasswordOnPasswordField(password);
			login.clickOnLogin();
			String actual=login.getPageTitle();
			String expected="7rmart supermarket";
			Assert.assertEquals(actual, expected,"User able to login with Invalid credentials");
				
		}
		@Test
		public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException
		{
			String username=ExcelUtility.getStringData(2, 0,"LoginPage");
			String password=ExcelUtility.getStringData(2, 1,"LoginPage");
			
			LoginPage login=new LoginPage(driver);//default constructor invoking
			login.enterUsernameOnUserNameField(username);
			login.enterPasswordOnPasswordField(password);
			login.clickOnLogin();
			String actual=login.getPageTitle();
			String expected="7rmart supermarket";
			Assert.assertEquals(actual, expected,"User able to login with Invalid credentials");
				
				
		}
		@Test
		public void verifyUserLoginWithInvalidUsernameAndInvalidPassword() throws IOException
		{
			String username=ExcelUtility.getStringData(3, 0,"LoginPage");//row/column/sheetname
			String password=ExcelUtility.getStringData(3, 1,"LoginPage");
			
			LoginPage login=new LoginPage(driver);//default constructor invoking
			login.enterUsernameOnUserNameField(username);
			login.enterPasswordOnPasswordField(password);
			login.clickOnLogin();
			String actual=login.getPageTitle();
			String expected="7rmart supermarket";
			Assert.assertEquals(actual, expected,"User able to login with Invalid credentials");
				
				
		}
		@Test
		public void verifyUserLoginWithBlankUsernameAndBlankPassword() throws IOException
		{
			String username=ExcelUtility.getStringData(4, 0,"LoginPage");//row/column/sheetname
			String password=ExcelUtility.getStringData(4, 1,"LoginPage");
			
			LoginPage login=new LoginPage(driver);//default constructor invoking
			login.enterUsernameOnUserNameField(username);
			login.enterPasswordOnPasswordField(password);
			login.clickOnLogin();
			String actual=login.getPageTitle();
			String expected="7rmart supermarket";
			Assert.assertEquals(actual, expected,"User able to login with Invalid credentials");
				
				
		}
		
}
