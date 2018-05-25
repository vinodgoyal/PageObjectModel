package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase{
	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	String sheetName="contacts";
	
	
	public ContactPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		intilization();
		testUtil=new TestUtil();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage= homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest(){
		contactsPage.selectContactsByName("rahul boss");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest(){
		contactsPage.selectContactsByName("john richard");
		contactsPage.selectContactsByName("mike ross");
	}
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4,dataProvider="getCRMTestData")
	public void validateCreateNewContactTest(String title, String firstName, String lastName, String company){
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.","Tom","Peter","Google");
		contactsPage.createNewContact(title,firstName,lastName,company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
