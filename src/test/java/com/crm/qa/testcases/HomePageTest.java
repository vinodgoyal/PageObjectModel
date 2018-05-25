package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
//Test case should be seperate--Independent with each other.
//Before each test case launch the browser
//@test--execute the test case
//After each test case close the browser
	
	@BeforeTest
	public void setup() {
		intilization();
		testUtil=new TestUtil();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle=homePage.verifyHomePageTitle();
		System.out.println("homePageTitle=" +homePageTitle);
		//Assert.assertEquals(homePageTitle,"CRMPRO","Home Page title is not matching");
		Assert.assertEquals(homePageTitle,"Free CRM software in the cloud powers sales and customer service","Home Page title is not matching");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactLinkTest() {
		//testUtil.switchToFrame();
	 contactsPage= homePage.clickOnContactsLink();
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}


}
