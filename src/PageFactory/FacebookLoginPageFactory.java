package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FacebookLoginPageFactory {

	WebDriver driver;
	
	@FindBy(how = How.NAME, using = "email")
	@CacheLookup
	WebElement login;
	
	@FindBy(name = "pass")
	@CacheLookup
	WebElement password;
	
	@FindBy(id = "loginbutton")
	@CacheLookup
	WebElement enter;


	public FacebookLoginPageFactory(WebDriver driver2) {
		this.driver = driver2;
	}

	public void loginToFacebook(String name, String pass) {
		login.sendKeys(name);
		password.sendKeys(pass);
		enter.click();
	}

	public void typeName(String name) {
		login.sendKeys(name);
	}

	public void typePass(String pass) {
		password.sendKeys(pass);
	}

	public void clickLogin() {
		enter.click();
	}
}
