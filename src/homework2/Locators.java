package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Locators {
	WebDriver driver;

	By login1 = By.xpath("//input[@id='email']");
	By password1 = By.xpath("//input[@id='pass']");
	By buttonEntry1 = By.name("login");
	By login2 = By.id("email");
	By password2 = By.id("pass");
	By buttonEntry2 = By.xpath("//div[@class='_6ltg']/button[@value='1']");

	public Locators(WebDriver driver) {
		this.driver = driver;
	}

	public void loginFBRemote(String username, String password) {
		driver.findElement(login1).sendKeys(username);
		driver.findElement(password1).sendKeys(password);
		driver.findElement(buttonEntry1).click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(By.className("buofh1pr"));
	}

	public void typeName(String name) {
		driver.findElement(login2).sendKeys(name);
	}

	public void typePass(String pass) {
		driver.findElement(password2).sendKeys(pass);
	}

	public void clickLogin() {
		driver.findElement(buttonEntry2).click();

	}

}
