package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page Object 0r Object repository
	@FindBy(xpath = "//td[contains(text(),'User: Vinod Goyal')]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath ="//a[contains(text(),'New Contact')]" )
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//Intillazation
		public HomePage() {
			PageFactory.initElements(driver,this);
		}
		
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	public void clickOnNewContactLink(){
		Actions act =new Actions(driver);
		act.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
	
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	

}
