package four;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class frame {

	@SuppressWarnings("null")
	public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.navigate().to("https://chercher.tech/practice/frames-example-selenium-webdriver");
    	
    	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
    	
    	WebElement frameTopic = driver.findElement(By.id("frame1"));   	
    	driver.switchTo().frame(frameTopic);
    	
    	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("OuwTitle");
    	
    	WebElement frameCheckbox = driver.findElement(By.id("frame3"));   	
    	driver.switchTo().frame(frameCheckbox);   	
    	
    //	driver.findElement(By.xpath("//input[@type='checkbox']")).click();
    	
    	if(driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected()) {
    		System.out.println("Checkbox is selected");
    	} else  {
    		System.out.println("Checkbox is NOT selected");
    	}
    	
    	driver.switchTo().parentFrame();
    	
    	driver.findElement(By.xpath("//input[@type='text']")).clear();
    	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("New OuwTitle");
    	
    //	driver.switchTo().frame("frame.0.subframe");
    	driver.switchTo().parentFrame();
    	
    	WebElement frame = driver.findElement(By.id("frame2"));   	
    	driver.switchTo().frame(frame);
    	
    	WebElement dropdown = driver.findElement(By.xpath("//select[@id='animals']"));
    	
    	Select select = new Select(dropdown);
    	select.selectByVisibleText("Baby Cat");
    	
    	
//ФРЕЙМЫ
		// переключение на первый фрейм	
		//		driver.switchTo().frame(1);
	/*			
		// переключение на фрейм по имени или id
				WebElement MyFrame=(WebElement) driver.switchTo().frame("name");
				driver.switchTo().frame("id");
				
		// переключение на фрейм по типу элемента	
				driver.switchTo().frame(MyFrame);
				
		//последовательное переключение на вложенные фреймы
				driver.switchTo().frame("frame.0.subframe");
				
		//выйти из фреймов
				driver.switchTo().defaultContent();
				
		// подняться на уровень выше 
				driver.switchTo().parentFrame(); 
				
		//перейти к определенному фрейму
				driver.switchTo().frame(driver.findElement(By.id("frameId")));
*/
				
			//	driver.close();
	}
}