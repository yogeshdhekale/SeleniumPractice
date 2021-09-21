package com.qa.hubspot.tests;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utilities.Constants;

public class LoginPageTest {
	
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
	basePage = new BasePage();
	prop = basePage.init_properties();
	driver = basePage.drive_init(prop);
	loginPage = new LoginPage(driver);
	}
	
	@Test(priority=1)
	public void loginPageTitle() throws IOException {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is" + title);
		Assert.assertEquals(title, Constants.login_page_title);
		File imageFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(imageFile, new File("/Users/yogeshdhekale/Downloads/TestImage1.png"));
	}
	
	@Test(priority=2)
	public void signUplinkTest() {
		Assert.assertTrue(loginPage.signUplinkchk());
		
	}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}
	

}
