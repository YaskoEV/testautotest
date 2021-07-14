package homework2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenCloseBrowser {
	WebDriver driver;

	/*
	 * public OpenCloseBrowser(WebDriver driver) {
	 * 
	 * this.driver = driver; }
	 */

	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://www.facebook.com");
	}

	public void closeBrowser() {
		driver.quit();
	}

}
