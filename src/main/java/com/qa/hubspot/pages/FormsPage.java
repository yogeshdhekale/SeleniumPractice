package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.BasePage.BasePage;

public class FormsPage extends BasePage{
	
	WebDriver driver;
	
	By title = By.id("title");
	By reportEmail = By.name("report_email");
	By description = By.name("description");
	By welcome_message = By.name("welcome_message");
	By confirmMessage = By.name("confirmation_message");
	By saveButton = By.xpath("//*[@id=\"feedbackForm\"]/table/tbody/tr[8]/td/input");
	
	public FormsPage(WebDriver driver) {
		this.driver = driver;
}
	
	public void createNewForm(String formTitle, String email, String desc, String welcome, String confirm) {
	
		driver.findElement(title).sendKeys(formTitle);
		driver.findElement(reportEmail).sendKeys(email);
		driver.findElement(description).sendKeys(desc);
		driver.findElement(welcome_message).sendKeys(welcome);
		driver.findElement(confirmMessage).sendKeys(confirm);	
		driver.findElement(saveButton).click();
	}

}
