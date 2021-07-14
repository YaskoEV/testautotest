package FrameworkDDT.Tests;

import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSWriterEvent;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import FrameworkDDT.Utils.ReadExcelFile;


public class DataDrivenTest {
	WebDriver driver;
	
@BeforeTest
public void BeforeTest(){
	System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
	driver.navigate().to("https://www.facebook.com/");
	System.out.println("Launched the chrome browser with the given url");
	//lkjljj

}

@BeforeMethod
public void Method(){
	driver.navigate().to("https://www.facebook.com/");
}

@Test (dataProvider="exceldata")
public void test1(String username, String pass) throws InterruptedException {
	driver.findElement(By.name("email")).sendKeys(username);
	driver.findElement(By.name("pass")).sendKeys(pass);
	driver.findElement(By.name("login")).click();
	//TimeUnit.SECONDS.sleep(5);
	String text = driver.findElement(By.xpath("//a[contains(text(),'Создайте новый аккаунт Facebook.')]")).getText();
	Assert.assertEquals(text,"Создайте новый аккаунт Facebook.");
}

@DataProvider(name="exceldata")
public Object[][] TestDataFeed()
{
	ReadExcelFile config = new ReadExcelFile("src/FrameworkDDT/DataExcel/FacebookLogin.xlsx");
	//Workbook writes = new HSSFWorkbook();
	int rows = config.getRowCount(0); // количество строк на листе 1, если нужен пятый лист в списке, config.getRowCount(4)
	Object[][] credentials = new Object[rows][2];
	for (int i=0; i<rows-1; i++) {
		credentials[i][0] = config.getData("data",i+1,1);
		credentials[i][1] = config.getData("data",i+1,2);
	}
	return credentials;
}
}
