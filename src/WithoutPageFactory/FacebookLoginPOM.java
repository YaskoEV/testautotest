package WithoutPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookLoginPOM {

	WebDriver driver;
	By login = By.name("email");
	By password = By.name("pass");
	By enter = By.id("loginbutton");

	public FacebookLoginPOM(WebDriver driver2) {
		this.driver = driver2;
	}

	public void loginToFacebook(String name, String pass) {
		driver.findElement(login).sendKeys(name);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(enter).click();
	}

	public void typeName(String name) {
		driver.findElement(login).sendKeys(name);
	}

	public void typePass(String pass) {
		driver.findElement(password).sendKeys(pass);
	}

	public void clickLogin() {
		driver.findElement(enter).click();
	}
}
