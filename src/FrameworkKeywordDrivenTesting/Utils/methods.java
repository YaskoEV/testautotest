 package FrameworkKeywordDrivenTesting.Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class methods {

	static WebDriver driver;
	
	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	public static void navigateTo(String Url) {
		driver.get(Url);		
	}
	
	public static void enterUsername(String locators,String value,String param) {
		if(locators.contentEquals("id")) {
			driver.findElement(By.id(value)).sendKeys(param);
		} else {
			driver.findElement(By.name(value)).sendKeys(param);
		}
	}
	
	public static void enterPassword(String locators,String value,String param) {
		if(locators.contentEquals("id")) {
			driver.findElement(By.id(value)).sendKeys(param);
		} else {
			driver.findElement(By.name(value)).sendKeys(param);
		}
	}
	
	public static void clickSubmit(String locators,String value,String param) {
		if(locators.contentEquals("id")) {
			driver.findElement(By.id(value)).click();
		} else {
			driver.findElement(By.xpath(value)).click();
		}
	}
	
	public static void verifyMessage(String locators, String value, String param) {

		if(locators.contentEquals("id")) {
			driver.findElement(By.id(value)).sendKeys(param);
		} else {
			driver.findElement(By.xpath(value)).sendKeys(param);
		}
	}
	public static void closeBrowser() {
		driver.close();		
	}
	
}
