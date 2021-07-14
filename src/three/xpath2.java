package three;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpath2 {
	public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.facebook.com");
        
        //������������� ������� ��� Email ��� ��������
		driver.findElement(By.xpath("//table[@role='presentation']/tbody/tr[2]/td/input[@id='email']"));
		//�������� ����� Email ��� �������"
		driver.findElement(By.xpath("//label[contains(text(),'����������� ����� ��� ����� ��������'"));
		//�������� ������� ATTRIBUTENAME �� ��������� AtributeValue
		driver.findElement(By.xpath("//label[contains(@for,'email'"));
		//���������� � ������ �Facebook �������� ��� ������ ���������� �� ����� � �������� �� ������ ���������
		driver.findElement(By.xpath("//div[starts-with(text(),'Facebook'"));
		//�������� �������� class ���������� � _5iyx
		driver.findElement(By.xpath("//div[starts-with(@class,'_5iyx'"));
		//��� ����, ��������� �� //input[@id='email']
		driver.findElement(By.xpath("//input[@id='email']/following::*"));
		//��� ���� tr, ��������� �� //input[@id='email']
		driver.findElement(By.xpath("//input[@id='email']/following::tr"));
		//��� ���� ���� �� ������, ������ ���������, � � ����� � ���, ��������� �� //select[@id='day']
		driver.findElement(By.xpath("//select[@id='day']/following-sibling::*"));
		//��� ���� select/option ���� �� ������, ��������� �� ���������, � � ��������� ������ � ����
		driver.findElement(By.xpath("//select[@id='day']/following-sibling::select/option"));
		//�������������� ����, ������ ���������
		driver.findElement(By.xpath("//input[@id='day']/preceding::*"));
		//�������������� ���� select/option, ������ ���������, � � ���� ����� email
		driver.findElement(By.xpath("//input[@id='pass']/preceding::input[1]"));
		//�������������� ���� ���� �� ������, ������ ���������, � � ���� � ����� 
		driver.findElement(By.xpath("//select[@id='year']/preceding-sibling::*"));
		//�������������� ���� select/option ���� �� ������, ������ ���������, � � ��������� ����  � ������ 
		driver.findElement(By.xpath("//select[@id='year']/preceding-sibling::select/option"));	
		
		//xpath ��� ����� ������ � �� - ������. ���������! (���������� � html)
		// � ������ ���������� ��������� ����� ������
		
	}
}
