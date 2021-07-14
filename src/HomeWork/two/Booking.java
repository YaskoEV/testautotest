package HomeWork.two;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Booking {
	public static void main(String [] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./chromedriver83.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//откыть станицу
		driver.navigate().to("https://www.booking.com");
		
		//инять куки
		driver.findElement(By.xpath("//button[@data-track-event='m_cookie_warning_closed']")).click();
		
		driver.findElement(By.xpath("//li[@id='current_account']//div[1]")).click();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("mail@mail.com");
		driver.findElement(By.xpath("//button[@class='bui-button bui-button--large bui-button--wide']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#password")).sendKeys("mail");
		driver.findElement(By.xpath("//button[@class='bui-button bui-button--large bui-button--wide']")).click();
		Thread.sleep(3000);

		driver.close();

	}
} 	 