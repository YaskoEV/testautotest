package main.seven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Headless {
	
    public static void main(String[] args){
    	System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        //options.addArguments("window-size=1920x1080");


        /*WebDriver driver = new ChromeDriver(options);
        driver.get("https://google.com");
        WebElement el = driver.findElement(By.name("q"));
        el.sendKeys("Selenium Java");
        el.sendKeys(Keys.ENTER);
        List<WebElement> list = driver.findElements(By.xpath(".//a[@href]/following::h3/.."));
        for(WebElement url: list) {
            System.out.println(" href= " + url.getAttribute("href") +" tag= " + url.getTagName()+" text= " + url.getText());*/

            WebDriver driver = new ChromeDriver(options);
            driver.get("https://google.com");
            System.out.println("header = " + driver.getTitle());
            WebElement el = driver.findElement(By.name("q"));
            el.sendKeys("SU-1640");
            el.sendKeys(Keys.ENTER);
            List<WebElement> list = driver.findElements(By.xpath(".//a[@href]/following::h3/.."));
            for(WebElement url: list) {
                System.out.println(" href= " + url.getAttribute("href") +" tag= " + url.getTagName()+" text= " + url.getText());
                //System.out.println(" href= " + url.getAttribute("href"));
            }
			
			  System.out.println(driver.toString());
			  //System.out.println(driver.getPageSource());
			 

 
        
        

    }
}
