package three;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class css {
	public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("newLogin");
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("pass");
		driver.findElement(By.xpath("//button[@id='Login']")).click();
		driver.findElement(By.cssSelector("#Login")).sendKeys("pass");
/**
css �������� � 10 ��� �������, ��� Xpath

css - ����������������� xpath
#idname - ��� id
.classname - ��� �������� ������� - ��������� ������� �� ����� � �������� �������
����� ���������� ��������
���������� ��������� css � Chropath
*/

	}

}

