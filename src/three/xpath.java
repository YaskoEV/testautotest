package three;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpath {
	public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.facebook.com");
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
  /*      
        //������������� ������� ��� Email ��� ��������
		driver.findElement(By.xpath("//input[@id='email']"));
		//�������� ����� Email ��� �������"
		driver.findElement(By.xpath("//input[@placeholder='����������� ����� ��� ����� ��������']"));

		//���������� � ������ �Facebook �������� ��� ������ ���������� �� ����� � �������� �� ������ ���������
		driver.findElement(By.xpath("//h2[starts-with(text(),'Facebook')]"));
		//�������� �������� class ���������� � _5iyx
		driver.findElement(By.xpath("//div[starts-with(@class,'_8esj')]"));
		//��� ����, ��������� �� //input[@id='email']
		driver.findElement(By.xpath("//input[@id='email']/following-sibling::*"));
		//��� ���� tr, ��������� �� //input[@id='email']
	//	driver.findElement(By.xpath("//input[@id='email']/following::tr]"));
	 
	 */
		//��� ���� ���� �� ������, ������ ���������, � � ����� � ���, ��������� �� //select[@id='day']
		driver.findElements(By.xpath("//select[@id='day']/following-sibling::*"));
		//��� ���� select/option ���� �� ������, ��������� �� ���������, � � ��������� ������ � ����
		driver.findElement(By.xpath("//select[@id='day']/following-sibling::select[1]")).click();
		driver.findElement(By.xpath("//select[@id='day']/following-sibling::select/option[@value='3']"));
		//�������������� ����, ������ ���������
		driver.findElement(By.xpath("//input[@id='day']/preceding::*]"));
		//�������������� ���� select/option, ������ ���������, � � ���� ����� email
		driver.findElement(By.xpath("//input[@id='pass']/preceding::input[1]"));
		//�������������� ���� ���� �� ������, ������ ���������, � � ���� � ����� 
		System.out.println("�������������� ����: "+driver.findElement(By.xpath("//select[@id='year']/preceding-sibling::*]")).getAttribute("name"));
		//�������������� ���� select/option ���� �� ������, ������ ���������, � � ��������� ����  � ������ 
		driver.findElement(By.xpath("//select[@id='year']/preceding-sibling::select/option"));	
		
		//xpath ��� ����� ������ � �� - ������. ���������! (���������� � html)
		// � ������ ���������� ��������� ����� ������
		
	}
}
