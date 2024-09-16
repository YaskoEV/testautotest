
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class findBy {
	
	@Test
	public static void main(String[] args) throws InterruptedException {
    	System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.facebook.com");
        System.out.println("Launched the chrome browser with the given url");
        driver.manage().window().maximize();
        //заполняем имя/почту
        driver.findElement(By.name("email")).sendKeys("xxx@gmail.com");
        // заполняем пароль
        driver.findElement(By.name("pass")).sendKeys("xxxxxx");
        //нажимаем Войти
        driver.findElement(By.name("login")).click();
        //login
        Thread.sleep(30000);
		driver.close();
		System.out.println("Завершение - ок");
		//Тест слияний и т.д.

		
		/*
		driver.findElement(By.id("search-inp"));
		driver.findElement(By.name("user_v1[query]"));
		driver.findElement(By.className("search_inp collapse giTrackElementHeader"));
		driver.findElement(By.tagName("input"));
		driver.findElement(By.cssSelector(".search_inp.collapse.giTrackElementHeader"));
		driver.findElement(By.xpath("//input[@id=search-inp]"));
		driver.findElement(By.linkText("javascript:void(0);"));
		driver.findElement(By.partialLinkText("void(0)"));
		 */

	}

}
