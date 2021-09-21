package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utilities.Constants;

public class HomePageTest {

	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.drive_init(prop);
		loginPage = new LoginPage(driver);
		//homePage = new HomePage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(10000);
	}
	
	@Test(priority=1)
	public void getTitle() {
		String title = homePage.getHomePageTitle();
		Assert.assertEquals(title, Constants.home_Page_Title);
	}
	
	@Test(priority=2)
	public void checkUserName(){
		String userName = homePage.GetUserID();
		Assert.assertEquals(userName, "Abcde Efghi");
	}
	
	@Test(priority=3)
	public void isHeaderDisplayed() {
		Assert.assertTrue(homePage.HomePageHeaderDisplay());
	}
	@Test
	public void checkLinkUpgrade() {
		Assert.assertTrue(homePage.checkUpgradeLink());
	}
	
	
	@AfterMethod
	public void quitBrowser() {
		driver.quit();
		
	}

}
