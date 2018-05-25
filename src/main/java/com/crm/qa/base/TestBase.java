package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		prop=new Properties();
		try {
//C:\Users\goyal\eclipse-workspace\FreeCRMTest_Practise\src\main\java\com\crm\qa\config\config.properties
			FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/crm/qa/config/config.properties");
			prop.load(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void intilization() {
		
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Users/goyal/Downloads/chromedriver");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:/Users/goyal/Downloads/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		EventFiringWebDriver e_driver= new EventFiringWebDriver(driver);
		WebEventListener webEL=new WebEventListener();
		e_driver.register(webEL);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
