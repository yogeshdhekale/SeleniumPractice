package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.utilities.ElementActions;

public class LoginPage extends BasePage {
	WebDriver driver;
	ElementActions elementActs;

	By userName = By.name("username");
	By pwd = By.name("password");
	By loginButton = By.xpath("//input[@value='Login' and @class='btn btn-small']");
	By signUplink = By.linkText("Sign Up");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementActs = new ElementActions(this.driver);
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();

	}

	public HomePage doLogin(String username, String password) {
		elementActs.doSendKeys(userName, username);
		elementActs.doSendKeys(pwd, password);
		elementActs.doClick(loginButton);
		
		return new HomePage(driver);
	}

	public boolean signUplinkchk() {
		return driver.findElement(signUplink).isDisplayed();
	}
	
	public void gitTest() {
		System.out.println("This method is added to test Git");
	}
}
