package main.seven;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class pics {
	
	@Test
	public void elementScreenshotTest(){
		System.setProperty("webdriver.gecko.driver", ".//drivers//FFdriver.exe");
	    WebDriver driver = new FirefoxDriver();
	    driver.get("http://gmail.com");
	    WebElement element = driver.findElement(By.xpath("//input[@name='identifier']"));
	    try {
	        FileUtils.copyFile(captureElementBitmap(driver, element), new File("c:\\tmp\\div.png"));
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

public static File captureElementBitmap(WebDriver driver, WebElement element) throws Exception {
    // Делаем скриншот страницы 
    File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    // Создаем экземпляр BufferedImage для работы с изображением
    BufferedImage img = ImageIO.read(screen);
    // Получаем размеры элемента
    int width = element.getSize().getWidth();
    int height = element.getSize().getHeight();
    // Создаем прямоугольник (Rectangle) с размерами элемента
    Rectangle rect = new Rectangle(width, height);
    // Получаем координаты элемента
    Point p = element.getLocation();
    // Вырезаем изображение элемента из общего изображения
    BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
    // Перезаписываем File screen
    ImageIO.write(dest, "png", screen);
    // Возвращаем File c изображением элемента
    return screen;
}}
