
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.Dimension;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.interactions.Actions;

public class toirTest {

	
	
		public static void main(String[] args) throws InterruptedException {
	        System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        //Открываем сылку
	        driver.get("https://toir-dev.refactorx.ru/#/account/login");
	        //увеличиваем размер окна 
	        driver.manage().window().maximize();
//	        driver.manage().timeouts();
	        WebElement fieldLogin = driver.findElement(By.name("username"));
	        fieldLogin.sendKeys("123");
	        WebElement fieldPassword = driver.findElement(By.id("password"));
	        fieldPassword.sendKeys("Qwe123@");
	        WebElement buttonEnt = driver.findElements(By.className("btn-block")).get(0);
	        buttonEnt.click();
	        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        Thread.sleep(5000);
	        String strUrl2 = driver.getCurrentUrl();
	        System.out.println("Url2:" + strUrl2);

	}

}
