package main.seven;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliFBLogin {

	public static void main(String[] args)throws FindFailed {
		// Создаем объект класса Screen - основной класс Sikuli, предоставляет все существующие в нем методы
		Screen screen = new Screen();
		// Создаем обьекты класса шаблонов, что бы загружать образцы изображений. Под каждое изображение отдельный объект
		Pattern username = new Pattern("pics/username.png");
		Pattern pass = new Pattern("pics/pass.png");
		Pattern loginB = new Pattern("pics/loginB.png");

		// Запускаем браузер
		System.setProperty("webdriver.chrome.driver", "./Chromedriver83.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		driver.navigate().to("https://facebook.com/");
		
		//ждем появления изображения, как на примере username
		screen.wait(username,10);
		//ввести значение в поле как на картинке
		screen.type(username, "dclind@mail.ru");
		screen.type(pass, "vfr4bgt5");
		
		// нажимаем на кнопку
		screen.click(loginB);
		
	}

}
