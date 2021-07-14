package three;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpath2 {
	public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.facebook.com");
        
        //относительный локатор дл€ Email или телефона
		driver.findElement(By.xpath("//table[@role='presentation']/tbody/tr[2]/td/input[@id='email']"));
		//содержит текст Email или “елефон"
		driver.findElement(By.xpath("//label[contains(text(),'Ёлектронный адрес или номер телефона'"));
		//содержит атрибут ATTRIBUTENAME со значением AtributeValue
		driver.findElement(By.xpath("//label[contains(@for,'email'"));
		//начинаетс€ с текста ЂFacebook помогает вам всегда оставатьс€ на св€зи и общатьс€ со своими знакомымиї
		driver.findElement(By.xpath("//div[starts-with(text(),'Facebook'"));
		//значение атрибута class начинаетс€ с _5iyx
		driver.findElement(By.xpath("//div[starts-with(@class,'_5iyx'"));
		//все ноды, следующие за //input[@id='email']
		driver.findElement(By.xpath("//input[@id='email']/following::*"));
		//все ноды tr, следующие за //input[@id='email']
		driver.findElement(By.xpath("//input[@id='email']/following::tr"));
		//все ноды того же уровн€, помимо указанной, т е мес€ц и год, следующие за //select[@id='day']
		driver.findElement(By.xpath("//select[@id='day']/following-sibling::*"));
		//все ноды select/option того же уровн€, следующие за указанной, т е выпадашки мес€ца и года
		driver.findElement(By.xpath("//select[@id='day']/following-sibling::select/option"));
		//предшествующие ноды, помимо указанной
		driver.findElement(By.xpath("//input[@id='day']/preceding::*"));
		//предшествующие ноды select/option, помимо указанной, т е поле ввода email
		driver.findElement(By.xpath("//input[@id='pass']/preceding::input[1]"));
		//предшествующие ноды того же уровн€, помимо указанной, т е дата и мес€ц 
		driver.findElement(By.xpath("//select[@id='year']/preceding-sibling::*"));
		//предшествующие ноды select/option того же уровн€, помимо указанной, т е выпадашки даты  и мес€ца 
		driver.findElement(By.xpath("//select[@id='year']/preceding-sibling::select/option"));	
		
		//xpath дл€ забыл пароль в ‘Ѕ - полный. ненадежно! (начинаетс€ с html)
		// в случае нескольких элементов берет первый
		
	}
}
