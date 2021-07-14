package PageFactory;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class FacebookLoginTestPageFactory {
	WebDriver driver;
	FacebookLoginPageFactory logPage;

	@Test
	public void emptyLogin() {

		FacebookLoginPageFactory logPage2= PageFactory.initElements(driver, FacebookLoginPageFactory.class);

		logPage.clickLogin();
	}

	@Test
	public void validLogin() {

		logPage.typeName("name");
		logPage.typePass("name");
		logPage.clickLogin();
	}

	@Test
	public void falsePass() {
		logPage.typeName("name");
		logPage.typePass("name");
		logPage.clickLogin();
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "chromedriver83.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@BeforeMethod
	public void BeforeMethod() {
		driver.get("http://www.facebook.com");
		logPage = new FacebookLoginPageFactory(driver);
		PageFactory.initElements(driver, logPage);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
