package com.qa.hubspot.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions {
	
	WebDriver driver;
	
	public ElementActions(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(By locator) {
		waitforElementPresent(locator);
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		}
		catch(Exception e) {
			System.out.println("Exception occurred while creating an element " + locator);
		}
		return element;
	}
	
	public void waitforElementPresent(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void doClick(By locator) {
		try {
			getElement(locator).click();
		}
		catch(Exception e) {
			System.out.println("Exception occurred while clicking on the element " + locator);
		}
	}
	
	public void doSendKeys(By locator,String value) {
		try {
			getElement(locator).clear();
			getElement(locator).sendKeys(value);
		}
		catch(Exception e) {
			System.out.println("Exception occurred while writing input into the element " + locator);
		}
	}

}
