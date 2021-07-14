package homeworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;


public class BrowserRun {
	WebDriver driver;
	@Parameters("browser")
	@Test
	public void openBrowser(String browser) {
		browser = browser.trim();
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver", ".//geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.out.println("InvalidBrowser");
		}
		
		
	}

}
