package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FaceBookAutorization2 {
	
	Datas d = new Datas();
	WebDriver driver;
	OpenCloseBrowser q = new OpenCloseBrowser();
	Locators loc = new Locators(driver);
	int i = 1;

	@BeforeMethod(groups = { "C" })
	public void open() {
		q.openBrowser();
	}
	
	@AfterMethod(groups = { "C" })
	public void close() {
		q.closeBrowser();
		if (i == 5)
			i = 1;
	}

	@Test(groups = { "B" }, priority = 8, dataProvider = "dataEntry1")
	public void loginFB(String username, String password) {

		System.out.println("Метод 1, " + i + "-й тест-сет");
		i++;
		//loc.typeName(username);
		q.driver.findElement(loc.login1).sendKeys(username);
		//loc.typePass(password);
		q.driver.findElement(loc.password1).sendKeys(password);
		q.driver.findElement(loc.buttonEntry1).click();
		for (String winHandle : q.driver.getWindowHandles()) {
			q.driver.switchTo().window(winHandle);
		}
		q.driver.findElement(By.className("buofh1pr"));

	}

	@Test(groups = { "A" }, priority = 4, dataProvider = "dataEntry2")
	public void loginFB2(String username, String password) {
		System.out.println("Метод 2, " + i + "-й тест-сет");
		i++;

		q.driver.findElement(By.id("email")).sendKeys(username);
		q.driver.findElement(By.id("pass")).sendKeys(password);
		q.driver.findElement(By.xpath("//div[@class='_6ltg']/button[@value='1']")).click();
		for (String winHandle : q.driver.getWindowHandles()) {
			q.driver.switchTo().window(winHandle);
		}
		q.driver.findElement(By.className("buofh1pr"));
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
