package homework2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FaceBookAutorization {

	Datas d = new Datas();
	WebDriver driver;
	int i = 1;

	@BeforeMethod(groups = { "C" })
	public void open() {

		System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://www.facebook.com");

	}

	@AfterMethod(groups = { "C" })
	public void close() {
		driver.quit();
		if (i == 5)
			i = 1;
	}

	@Test(groups = { "B" }, priority = 8, dataProvider = "dataEntry1")
	public void loginFB(String username, String password) {

		System.out.println("Метод 1, " + i + "-й тест-сет");
		i++;
		Locators logPage = new Locators(driver);
		logPage.loginFBRemote(username, password);

	}

	@Test(groups = { "A" }, priority = 4, dataProvider = "dataEntry2")
	public void loginFB2(String username, String password) {
		System.out.println("Метод 2, " + i + "-й тест-сет");
		i++;
		Locators logPage = new Locators(driver);
		logPage.typeName(username);
		;
		logPage.typePass(password);
		logPage.clickLogin();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(By.className("buofh1pr"));
	}

	@DataProvider
	public String[][] dataEntry1() {
		return d.dataEntry1();
	}

	@DataProvider
	public String[][] dataEntry2() {
		return d.dataEntry2();
	}
}
