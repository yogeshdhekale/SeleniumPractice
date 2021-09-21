package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pages.ProductAdd;

public class ProductPageTest {

	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	ProductAdd productPage;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.drive_init(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		productPage = homePage.gotoProductsPage();
	}

	@Test
	public void createNewProduct() {
		productPage.createNewProduct("Abcde", "24.50", "25.00", "23.00", "250.00", "This is QA Testing");
	}

}