import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestClassFirefox {

	public static void main(String[] args) {
		 System.setProperty("webdriver.geckodriver.driver", ".//geckodriver.exe");
	        WebDriver driver = new FirefoxDriver();
	        driver.get("https://habr.com");
	        String strUrl = driver.getTitle();
	        //System.out.println("Title: " + strUrl);
	        if (strUrl.equals("Все публикации подряд / Хабр")) {
	            System.out.println("Название страницы: " + strUrl);
	        }
	        else System.out.println("Название страницы не соответствует параметрам");
	 
	        driver.manage().window().maximize();
	        WebElement buttonEnt = driver.findElement(By.id("login"));
	        buttonEnt.click();
	        driver.getCurrentUrl();
	        WebElement fieldLogin = driver.findElement(By.id("email_field"));
	        fieldLogin.sendKeys("yaskoev@mail.ru");
	        WebElement fieldPassword = driver.findElement(By.id("password_field"));
	        fieldPassword.sendKeys("Test@3812");
	        WebElement autorztn = driver.findElement(By.name("go"));
	        autorztn.click();

	}

}
