package TestNG;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(TestNG.Listener.class)

public class FacebookLoginLog {
	WebDriver driver;

	@Parameters("browser")
	@Test(testName = "Авторизация")
	public void openBrowser(@Optional("Chrome") String browser) {
		browser = browser.trim();

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./chromedriver83.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver", ".//FFdriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.out.println("InvalidBrowser");
		}
		Reporter.log("Открыли браузер");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.facebook.com");
		Reporter.log("Открыли страницу");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("dclind@mail.ru");
		driver.findElement(By.name("pass")).sendKeys("vfr4bgt5");
		driver.findElement(By.id("u_0_b")).click();

		String expectedTitle = "Facebook";
		String originalTitle = driver.getTitle();
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(originalTitle, expectedTitle, "softassert");

		// Assert.assertEquals(originalTitle, expectedTitle, "Названия не совадают");
		Reporter.log("Закончили", true);
		driver.quit();
		softassert.assertAll();
		// Assert.assertTrue(false);
	}
}
