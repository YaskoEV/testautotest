package homeworks;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Grid {
	String browserType = "chrome";
	
	@Test
	public void mailTestLocal() throws MalformedURLException, InterruptedException {

		
		//System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
		//WebDriver driver = new  ChromeDriver();
		//WebDriverWait wait = new WebDriverWait(driver, 10000);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.10.108:4444/wd/hub"), DesiredCapabilities.internetExplorer());
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		driver.navigate().to("http://gmail.com");
		driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys("username@gmail.com");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Далее']")));
		driver.findElement(By.className("VfPpkd-RLmnJb")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='headingText']")));
		System.out.println(driver.findElement(By.xpath("//*[@id='headingText']")).getText());
		driver.close();
	}

	@Test(enabled = false) 
	public void mailTest() throws MalformedURLException {
		DesiredCapabilities dr = null;
		if (browserType.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
			dr = DesiredCapabilities.chrome();
			dr.setBrowserName("chrome");
			dr.setPlatform(Platform.WIN10); //Grid воспринимает Windows-7 как Vista
	//		dr.setVersion("87.0.4280.88");

		} else {
			if (browserType.equals("FF")) {
				System.setProperty("webdriver.gecko.driver", ".//geckodriver.exe");
				dr = DesiredCapabilities.firefox();
				dr.setBrowserName("firefox");
				dr.setPlatform(Platform.WIN10);

			} /*
				 * else { System.setProperty("webdriver.ie.driver",".//IEDriver.exe"); dr =
				 * DesiredCapabilities.internetExplorer(); dr.setBrowserName("iexplore");
				 * dr.setPlatform(Platform.WIN10); }
				 */
		}
		
		System.out.println("dr = "+dr.toString());

		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.10.108:4444/wd/hub"), dr);
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		driver.navigate().to("https://gmail.com");
		driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys("username@gmail.com");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Далее']")));
		driver.findElement(By.xpath("//span[text()='Далее']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='headingText']")));
		System.out.println(driver.findElement(By.xpath("//*[@id='headingText']")).getText());
		driver.close();
	}
}
