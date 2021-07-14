

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Element {

     public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver", "./chromedriver75.exe");
    	WebDriver driver2 = new ChromeDriver();
		driver2.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		driver2.get("http://google.com");
        
        driver2.manage().window().maximize();
        //search
	WebElement e=driver2.findElement(By.name("q"));
	e.sendKeys("specialist");

	String enteredText = e.getAttribute("value"); 
	System.out.println("В поле поиска введено значение "+enteredText);
	e.clear(); 
	enteredText = e.getAttribute("value"); 
	System.out.println("Очистили поле поиска, теперь значение в нем "+enteredText);
	System.out.println("Остальные атрибуты поля:: ");	
	System.out.println("id:: " + e.getAttribute("id"));	
	System.out.println("name:: " +e.getAttribute("name"));	
	System.out.println("class:: " +e.getAttribute("class"));
	 
	System.out.println("location:: " +e.getLocation());//Returns the Location of the WebElement. A point, containing the location of the top left-hand corner of the element	
	System.out.println("size:: " +e.getSize());	
	System.out.println("color:: " +e.getCssValue("background-color"));	
	System.out.println("fontsize:: " +e.getCssValue("font-size"));
	System.out.println("Tag Name:: " + e.getTagName());
	driver2.quit();
	}
}
