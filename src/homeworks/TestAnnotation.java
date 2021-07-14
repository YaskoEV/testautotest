package homeworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestAnnotation{
	@Test
	public void test1() {
		int a=3, b=4;
		System.out.println("Первый тест = " + (a+b));
	}
	 @BeforeGroups
	  public void beforeGroup() {
		  System.out.println("====beforeGroup");
		  System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.aviasales.ru/");
			driver.manage().window().maximize();
	  }

	  @AfterGroups
	  public void afterGroup() {
		  System.out.println("====afterGroup");
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("====beforeMethod");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("====afterMethod");
	  }

	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("====beforeClass");
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("====afterClass");
	  }

	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("====beforeTest");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("====afterTest");
	  }

	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("====beforeSuite");
	  }

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("====afterSuite");
	  }

}
