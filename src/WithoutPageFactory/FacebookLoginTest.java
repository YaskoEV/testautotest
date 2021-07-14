package WithoutPageFactory;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class FacebookLoginTest {
	WebDriver driver;

	@Test
	public void emptyLogin() {

		FacebookLoginPOM logPage = new FacebookLoginPOM(driver);
		PageFactory.initElements(driver, logPage);

//	  FacebookLoginPOM logPage2= PageFactory.initElements(driver, FacebookLoginPOM.class);

		logPage.clickLogin();
	}

	@Test
	public void validLogin() {
		FacebookLoginPOM logPage = new FacebookLoginPOM(driver);
		logPage.typeName("validLogin");
		logPage.typePass("name");
		logPage.clickLogin();
	}

	@Test
	public void falsePass() {
		FacebookLoginPOM logPage = new FacebookLoginPOM(driver);
		logPage.typeName("falsePass");
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
	public void Method() {
		driver.get("http://www.facebook.com");
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
