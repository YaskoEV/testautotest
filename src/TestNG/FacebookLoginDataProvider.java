package TestNG;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class 		FacebookLoginDataProvider {	
	WebDriver driver;
	
@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//chromedriver83.exe");
		 driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.facebook.com");
}


@Test(dataProvider = "inputData")  //(dataProvider = "inputData", dataProviderClass = DataProviderClass.class)
public void loginFacebook(String username, String password) {
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("pass")).sendKeys(password);
		driver.findElement(By.id("loginbutton")).click();
		System.out.println(driver.getCurrentUrl());
	}

@AfterMethod
public void closeBrowser() {
	
	driver.quit();
}

@DataProvider 
public String[][] inputData(){
	String[][] data = new String[4][2];
	
	data[0][0]="dclind@mail.ru";
	data[0][1]="5555";
	
	data[1][0]="dclind@mail.ru";
	data[1][1]="vfr4bgt5";
	
	data[2][0]="555dclind@mail.ru";
	data[2][1]="55555";
	
	data[3][0]="dclind@mail.ru";
	data[3][1]="vfr4bgt5";
	
	return data;
}
}
