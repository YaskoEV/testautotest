package homework2;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FB {
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

	@Test(groups = { "B" }, priority = 8, dataProvider = "dataEntry1")
	public void loginFB(String username, String password) {

		System.out.println("Метод 1, " + i + "-й тест-сет");
		i++;

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(By.className("buofh1pr"));

	}

	@Test(groups = { "A" }, priority = 4, dataProvider = "dataEntry2")
	public void loginFB2(String username, String password) {
		System.out.println("Метод 2, " + i + "-й тест-сет");
		i++;

		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.xpath("//div[@class='_6ltg']/button[@value='1']")).click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(By.className("buofh1pr"));
	}

	@AfterMethod(groups = { "C" })
	public void close() {
		driver.quit();
		if (i == 5)
			i = 1;

	}

	@DataProvider
	public String[][] dataEntry1() {
		String[][] data = new String[4][2];

		data[0][0] = "energotest2009@mail.ru";
		data[0][1] = "Qwe123@686S%";

		data[1][0] = "dclind@mail.ru";
		data[1][1] = "Qwe123@686S%";

		data[2][0] = "energotest2009@mail.ru";
		data[2][1] = "55555";

		data[3][0] = "";
		data[3][1] = "";

		return data;
	}

	@DataProvider
	public String[][] dataEntry2() {
		String[][] data = new String[4][2];

		data[0][0] = "";
		data[0][1] = "";

		data[1][0] = "energotest2009@mail.ru";
		data[1][1] = "55555";

		data[2][0] = "dclind@mail.ru";
		data[2][1] = "Qwe123@686S%";

		data[3][0] = "energotest2009@mail.ru";
		data[3][1] = "Qwe123@686S%";

		return data;
	}
}
