package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	// Page Fatory or OR
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
 /*
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn ;
	*/
	//@FindBy(xpath="//input[@class='btn btn-small']")
	@FindBy(xpath="//div[@class='input-group-btn']/input")
	WebElement loginBtn ;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	/*
	@FindBy(xpath="//button[@class='btn']")
	WebElement signupBtn ;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement crmLogo ;
	*/
	
	// Intilailization
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	//Action
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", loginBtn);
		return new HomePage();
	}
}
