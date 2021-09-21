package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.pages.FormsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;

public class NewFormTest {
	
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	FormsPage newFormPage;
	
	@BeforeMethod
	public void setUP() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.drive_init(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		newFormPage = homePage.clickFormsMain();
	}
	
	@Test
	public void createNewForm() {
		newFormPage.createNewForm("Testing_QA", "siliconyoga@gmail.com",
				"This is QA", "Welcome message", "Confirmation message");		
		}

}
