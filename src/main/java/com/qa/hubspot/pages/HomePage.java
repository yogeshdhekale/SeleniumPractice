package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.hubspot.BasePage.BasePage;

public class HomePage extends BasePage{
	
	WebDriver driver;
	
	By header = By.xpath("/html/body/table[1]/tbody/tr[2]/td[1]/div/table/tbody/tr/td[1]");
	By userID = By.xpath("//td[@class='headertext' and contains(text(),'User')]");
	By upgradeLink = By.xpath("(//a[contains(text(),'Upgrade your account')])[2]");
	//By upgradeLink = By.xpath("//html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[2]/a");
	
	//By Products = By.xpath("(//a[@title='Products'])[2]");
	By Products = By.xpath("(//a[@title='Products' and contains (text(), 'Products')])[2]");
	
	//By FormsMainTab = By.xpath("//a[@title='Forms']");
	By FormsMainTab = By.linkText("Forms");
	//By NewFormsTab = By.xpath("//input[@type='button' and @value='New Form']");
	By NewFormsTab = By.linkText("New Form");
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean HomePageHeaderDisplay() {
		return driver.findElement(header).isDisplayed();
	}
	
	public String GetUserID() {
		String userName = driver.findElement(userID).getText();
		System.out.println(userName);
		return userName;
	}
	public boolean checkUpgradeLink() {
		return driver.findElement(upgradeLink).isEnabled();
		
	}
	
	public ProductAdd gotoProductsPage() {
		clickProducts();
		return new ProductAdd(driver);
	}
	
	public void clickProducts() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("(//a[@title='Products' and contains (text(), 'Products')])[2]")).click();
	//Thread.sleep(5000);
	}
	
	public FormsPage clickFormsMain() {
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(FormsMainTab)).build().perform();
		//act.click(driver.findElement(FormsMainTab)).build().perform();
		//driver.findElement(FormsMainTab).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//act.click(driver.findElement(NewFormsTab)).build().perform();
		driver.findElement(NewFormsTab).click();
		
		return new FormsPage(driver);
		
		//<a href="https://classic.freecrm.com/system/index.cfm?action=form" style="background: rgb(142, 68, 173);" title="Forms">Forms</a>
	}
	
	public void homePageVerifyTitle(){
		System.out.println("Home Page verify title");
}
