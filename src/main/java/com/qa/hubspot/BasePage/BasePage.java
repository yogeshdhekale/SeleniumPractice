package com.qa.hubspot.BasePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * 
 * @author yogeshdhekale
 *
 */
public class BasePage {
	
/**
 *  This method is used to initialize the drive on the basis of browser
 *  @return driver
 */

	WebDriver driver;
	Properties prop;

	public WebDriver drive_init(Properties prop) {

		String browser = prop.getProperty("browser");

		if (browser.equals("Chrome")) {
			String chromePath = "/Users/yogeshdhekale/Downloads/chromedriver";
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
		} else if (browser.equals("Firefox")) {
			String firefoxPath = "/Users/yogeshdhekale/Downloads/geckodriver";
			System.setProperty("webdriver.firefox.driver", firefoxPath);
			driver = new FirefoxDriver();
		} else if (browser.equals("Safari")) {
			String safariPath = "/usr/bin/safaridriver";
			System.setProperty("webdriver.safari.driver", safariPath);
			driver = new SafariDriver();
		} else {
			System.out.println("Please provide correct browser name");
		}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//SeleniumWait.withDriver(driver).withTimeOut(15).forElementToClick(element);
		
		return driver;
	}
	
	/**
	 * This method is used to get the properties from config file. 
	 * @return prop
	 */
	public Properties init_properties() {
		prop = new Properties();
		try {
			FileInputStream input = new FileInputStream("/Users/yogeshdhekale/eclipse-workspace/"
					+ "PageObjModelSeleniumPractice/src/main/java/com/qa/hubspot/config/config.properties");
			prop.load(input);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}