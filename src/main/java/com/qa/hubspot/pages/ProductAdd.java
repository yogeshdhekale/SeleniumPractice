package com.qa.hubspot.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.BasePage.BasePage;

public class ProductAdd extends BasePage{
	
	WebDriver driver;
	
	By NewProduct = By.xpath("//input[@class='button' and @value='New Product']");
	By inputName = By.id("name");
	By inputCost = By.id("cost");
	By inputRetail = By.id("retail_value");
	By inputwholesale = By.id("wholesale");
	By inputInventory_Amount = By.id("inventory_amount");
	By inputDesc = By.xpath("//*[@id=\"productForm\"]/table/tbody/tr[10]/td/textarea");
	By clickSave = By.xpath("//*[@id=\"productForm\"]/table/tbody/tr[11]/td/input");

	public ProductAdd (WebDriver driver) {
		this.driver=driver;
		
	}
	
	ArrayList<Object> arr = new ArrayList<Object>();
	
	public void createNewProduct(String name, String cost, String retail, 
			String wholesale, String invAmount, String description) {
		
		driver.findElement(NewProduct).click();
		driver.findElement(inputName).sendKeys(name);
		driver.findElement(inputCost).sendKeys(cost);
		driver.findElement(inputRetail).sendKeys(retail);
		driver.findElement(inputwholesale).sendKeys(wholesale);
		driver.findElement(inputInventory_Amount).sendKeys(invAmount);
		driver.findElement(inputDesc).sendKeys(description);
	}
	
	
}

