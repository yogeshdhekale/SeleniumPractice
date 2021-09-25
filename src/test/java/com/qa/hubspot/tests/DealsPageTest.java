package com.qa.hubspot.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.DealsPage;

public class DealsPageTest {
	
	DealsPage deals;
	WebDriver driver;

	/*
	 * This is test case for Deals Page
	 * 
	 */
	
	@Test
	public void titlTest() {
		deals = new DealsPage(driver);
		deals.creatDeal();
	}
}
