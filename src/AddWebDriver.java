

import java.util.Arrays;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;


public class AddWebDriver {

	public static void main(String[] args) {

//���������� ������� ��� �������� � ��������� �������
		System.setProperty("webdriver.opera.driver", ".//drivers//operadriver.exe");
	    OperaOptions options = new OperaOptions();
	    options.setBinary("C:\\Users\\annac\\AppData\\Local\\Programs\\Opera\\launcher.exe");
	    options.addArguments("start-maximized"); // open Browser in maximized mode
	    options.addArguments("disable-infobars"); // disabling infobars
	    options.addArguments("--disable-extensions"); // disabling extensions
	    options.addArguments("--disable-gpu"); // applicable to windows os only
	    options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
	    options.addArguments("--no-sandbox"); // Bypass OS security model
	    options.addArguments("--headless");
	    WebDriver driver = new OperaDriver(options);
/*				
		System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		WebDriver driver = Options.chromedriver();

		System.setProperty("webdriver.gecko.driver", ".//FFdriver.exe");
		driver = new FirefoxDriver();
		
		System.setProperty("webdriver.ie.driver",".//IEDriver.exe");
		WebDriver driver = new InternetExplorerDriver();
		
		System.setProperty("webdriver.opera.driver", ".//operadriver.exe");
		WebDriver driver = new OperaDriver();
		
		System.setProperty("webdriver.safari.driver",".//safaridriver.exe");
		WebDriver driver = new SafariDriver();
*/	
   
//������� ������
        driver.get("https://www.facebook.com");
        
//�������� �������� �������
        String title = driver.getTitle();
        
//�������� ��� ������� ��������
        driver.getPageSource();
        
//������� ����� ��������
        System.out.println(driver.getCurrentUrl());

//������� �� �������� � ����������� ������� ��������� � ��������, ������ ��������, �����, ������
        driver.navigate().to("https://www.facebook.com");
        driver.navigate().refresh();
        driver.navigate().back(); //������� ����� back ����� navigate � get
        driver.navigate().forward();
//������� ����        
        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(600, 300));
        
//�������� ��������� ������        
        driver.manage().deleteAllCookies();
     
   
//������� �������� �������
      //  driver.close();
//������� ������� ���������
        driver.quit();
     // ������������ �� ������ - ����� ������� �������� ������� � ������� ������� �� ��������� 
	}
}

