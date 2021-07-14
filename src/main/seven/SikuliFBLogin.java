package main.seven;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliFBLogin {

	public static void main(String[] args)throws FindFailed {
		// ������� ������ ������ Screen - �������� ����� Sikuli, ������������� ��� ������������ � ��� ������
		Screen screen = new Screen();
		// ������� ������� ������ ��������, ��� �� ��������� ������� �����������. ��� ������ ����������� ��������� ������
		Pattern username = new Pattern("pics/username.png");
		Pattern pass = new Pattern("pics/pass.png");
		Pattern loginB = new Pattern("pics/loginB.png");

		// ��������� �������
		System.setProperty("webdriver.chrome.driver", "./Chromedriver83.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		driver.navigate().to("https://facebook.com/");
		
		//���� ��������� �����������, ��� �� ������� username
		screen.wait(username,10);
		//������ �������� � ���� ��� �� ��������
		screen.type(username, "dclind@mail.ru");
		screen.type(pass, "vfr4bgt5");
		
		// �������� �� ������
		screen.click(loginB);
		
	}

}
