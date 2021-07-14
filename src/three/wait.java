package three;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class wait {
	
	static WebDriver driver;

	public static void main(String[] args) throws Exception  {
    	System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
   	driver = new ChromeDriver();
 /*  	 	driver.navigate().to("https://www.spicejet.com/");
// никогда не использовать
    			Thread.sleep(1000);
//implicit - ждет загрузки всех элементов. задается единожды и работает для объекта вебдрайвера
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.MILLISECONDS);
		
//explicit - ждет загрузки определенного элемента
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement myElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("123")));

		
//fluent - задает максимальное время ожидания события, частоту опроса состояния и может игнорировать ошибки поиска
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		Wait<WebDriver> fwait2 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(1));

//задает, сколько ждать, прежде, чем выбрость ошибку загрузки страницы
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		
//задает, сколько ждать асинхронный ответ
		driver.manage().timeouts().setScriptTimeout(50,TimeUnit.SECONDS);
		
//ожидает появления фрейма и переключается в него
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame"));
	*/	
   	wait forTest = new wait();
   	forTest.testUntitled() ;
		
	}
 
 // пример c поиском в гугле 
  public  void testUntitled() throws Exception {
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.MILLISECONDS);
	  
    driver.get("http://www.google.com");
    
    WebElement element = driver.findElement(By.name("q"));
    element.sendKeys("Selenium WebDriver Interview questions");
    element.sendKeys(Keys.RETURN);
   List<WebElement> list = driver.findElements(By.className("_Rm"));
   System.out.println(list.size());
 
	}


    public void ExpectedConditionExample() throws InterruptedException {
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
	
	
           // saving the GUI element reference into a "element" variable of WebElement type
           WebElement element =  driver.findElement(By.id("Email"));

           // entering username
           element.sendKeys("dummy@gmail.com");
           element.sendKeys(Keys.RETURN);

           // entering password
           driver.findElement(By.id("Passwd")).sendKeys("password");
	 
	       // clicking signin button
           driver.findElement(By.id("signIn")).click();
	 
	       // explicit wait - to wait for the compose button to be click-able
	       WebDriverWait wait = new WebDriverWait(driver,30);
	       
	       WebElement el1 =  driver.findElement( By.xpath("//div[contains(text(),'COMPOSE')]"));
	 
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
	       // click on the compose button as soon as the "compose" button is visible
           driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
	       }


}