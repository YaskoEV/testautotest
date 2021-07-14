package four;

import java.sql.Array;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class allert_Modal_Window_DragDrop {

	public static void main(String[] args) throws InterruptedException {
    	System.setProperty("webdriver.chrome.driver", "./chromedriver83.exe");
    	WebDriver driver = new ChromeDriver();
    	
    	driver.get("https://www.booking.com/index.ru.html");
    	
    	
    	
    	// Окна
	   				
     	driver.navigate().to("https://www.globalsqa.com/demo-site/frames-and-windows/#Open%20New%20Window");   	
    	Thread.sleep(3000);
    	WebElement tab = driver.findElement(By.xpath("//h1[contains(text(),'Frames And Windows')]"));
    	Actions action = new Actions(driver);
    	action.moveToElement(tab).perform();
    	tab = driver.findElement(By.xpath("//li[@id='Open New Window']"));

    	tab.click();
    	driver.findElement(By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//a[@class='button e.g. button_hilite button_pale small_button'][contains(text(),'Click Here')]")).click();
    	
    	Thread.sleep(3000);
    	System.out.println(driver.getWindowHandle());
		Object[] a = driver.getWindowHandles().toArray();
		System.out.println("Все окна: "+a.toString());
		driver.switchTo().window(a[1].toString());		
		System.out.println("текущее окно : "+driver.getWindowHandle());
    	
/*
		
//ОПОВЕЩЕНИЯ
		
		driver.navigate().to("https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html");
		driver.findElement(By.xpath("//button[@id='autoclosable-btn-success']")).click();
		Thread.sleep(1000);
		Alert MyAlert=driver.switchTo().alert();
		//Получить текст оповещения
				String Text = driver.switchTo().alert().getText();
				System.out.println(Text);
//Нажать OK
		driver.switchTo().alert().accept();
		
//Нажать Отмена
		driver.switchTo().alert().dismiss();
		

//Модальные окна 
		driver.navigate().to("https://www.seleniumeasy.com/test/bootstrap-modal-demo.html");
		driver.findElement(By.xpath("//body/div[@class='container-fluid text-center']/div[@class='row']/div[@class='col-md-6 text-left']/div[1]/div[1]/div[1]/div[2]/a[1]")).click();
	//	driver.switchTo().frame(driver.findElement(By.id("myModal0")));
		driver.switchTo().activeElement();
		
		System.out.println(driver.getWindowHandles().toString());

		
//Отправить текст в поле ввода
		driver.switchTo().alert().sendKeys("test");
		
		
		
//Модальные окна 
		driver.switchTo().frame(driver.findElement(By.id("ModalId")));
		driver.switchTo().activeElement();
		
//Drag&Drop
  driver.navigate().to("http://demo.guru99.com/test/drag_drop.html");
  WebElement sum = driver.findElement(By.xpath("//section[@id='g-container-main']//li[4]//a[1]"));
  
		WebElement From=driver.findElement(By.xpath("//*[@id='forth'][2]/a"));
		WebElement To=driver.findElement(By.xpath("//*[@id='bank']/li"));; 
		Actions action=new Actions(driver);
		Action dragdrop = action.clickAndHold(From).moveToElement(To).release(To).build();
		dragdrop.perform();
					
*/
	}
}
