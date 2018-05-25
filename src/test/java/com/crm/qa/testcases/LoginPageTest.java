package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		intilization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
	   String actualTitle= loginPage.validateLoginPageTitle();	
	   System.out.println("Actual Title of CRM Free is " +actualTitle);
	   Assert.assertEquals(actualTitle,"Free CRM software in the cloud powers sales and customer service");
	}
	@Test(priority=2)
	public void crmLogoImageTest() {
		 boolean flag= loginPage.validateCRMImage();
		 System.out.println("Flag Value" +flag);
		 Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void LoginTest() {
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
