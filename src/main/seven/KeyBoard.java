package main.seven;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class KeyBoard {

	public static void main(WebDriver driver, WebElement field) {
		
		Actions make = new Actions(driver);
		Action KeyBoard;
//Клавиатура	
// для keyDown есть модификаторы Keys.SHIFT Keys.TAB, Keys.CTRL
		KeyBoard = make.keyDown(field, Keys.SHIFT).sendKeys("our text").build();
		KeyBoard = make.keyUp(null).build();
		KeyBoard = make.doubleClick().build();  //двойной клик для выделения текста
		KeyBoard = make.contextClick().build();
		KeyBoard = make.release().build();  //отпустить зажатые кнопки
		KeyBoard.perform();
//Enter
		field.sendKeys(Keys.ENTER);
//Return
		field.sendKeys(Keys.RETURN);
		
// Мышь
		WebElement From=null;
		WebElement To=null; 
		Actions action=new Actions(driver);
		
//Движение мышки
				Action move = action.moveToElement(From).moveToElement(To).build();
				move.perform();
// скролл вниз
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,250)", "");
// скролл вверх
				jse.executeScript("scroll(0, -250);");
// скролл до элемента				
				jse.executeScript("arguments[0].scrollIntoView(true)",To);
	}
}
