package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;

import com.qa.hubspot.BasePage.BasePage;

public class DealsPage extends BasePage{
	/*
	 * Deals Page Methods
	 */
	
	WebDriver driver;

	public DealsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void creatDeal() {
		
		System.out.println("This is createDeal Page");
	}
}
