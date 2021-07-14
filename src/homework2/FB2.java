package homework2;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FB2 {
	OpenCloseBrowser open = new OpenCloseBrowser();

	@BeforeMethod
	public void openBrowser() {
		
		open.openBrowser();
	}

	@Test(dataProvider = "dataEntry")
	public void loginFB(String username, String password) {

		open.driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		open.driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
		open.driver.findElement(By.name("login")).click();
		for (String winHandle : open.driver.getWindowHandles()) {
			open.driver.switchTo().window(winHandle);
		}
		open.driver.findElement(By.className("buofh1pr"));
	}


	@AfterMethod
	public void closeBrowser() {
		open.closeBrowser();
	}

	@DataProvider
	public String[][] dataEntry() {
		String[][] data = new String[4][2];

		data[0][0] = "energotest2009@mail.ru";
		data[0][1] = "Qwe123@686S%";

		data[1][0] = "dclind@mail.ru";
		data[1][1] = "vfr4bgt5";

		data[2][0] = "555dclind@mail.ru";
		data[2][1] = "55555";

		data[3][0] = "dclind@mail.ru";
		data[3][1] = "vfr4bgt5";

		return data;
	}
}
