package main.seven;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardFacebookLogin {
	public static void main(String[] args) throws InterruptedException {
		KeyBoardFacebookLogin obj = new KeyBoardFacebookLogin();
		obj.loginBrowser();
	}

	public void loginBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.facebook.com");
// перепишем строку через методы драйвера на методы взаимодействия с клавиатурой
// было driver.findElement(By.name("email")).sendKeys("dclind@mail.ru");
		WebElement email = driver.findElement(By.name("email"));
		Actions actions=new Actions(driver);
		Action email_fill=actions.keyDown(email, Keys.SHIFT).sendKeys("dclind@mail.ru").keyUp(email, Keys.SHIFT).build();
		email_fill.perform();
		//можно объединить 2 строки (35 и 36) и не выделять объект типа Action
		//actions.keyDown(email, Keys.SHIFT).sendKeys("dclind@mail.ru").build().perform();

//		driver.findElement(By.name("pass")).sendKeys("vfr4bgt5");
		WebElement pass = driver.findElement(By.name("pass"));
		//Actions actions=new Actions(driver);  - второй раз объект действий создавать не надо
// так как зажали SHIFT, пароль не проходит
		Action pass_fill=actions.keyDown(pass, Keys.SHIFT).sendKeys("vfr4bgt5").keyUp(pass, Keys.SHIFT).doubleClick().contextClick().build();
		pass_fill.perform();
				
		
		driver.findElement(By.id("loginbutton")).sendKeys(Keys.ENTER);

	}
}
