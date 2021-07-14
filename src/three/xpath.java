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
        //относительный локатор дл€ Email или телефона
		driver.findElement(By.xpath("//input[@id='email']"));
		//содержит текст Email или “елефон"
		driver.findElement(By.xpath("//input[@placeholder='Ёлектронный адрес или номер телефона']"));

		//начинаетс€ с текста ЂFacebook помогает вам всегда оставатьс€ на св€зи и общатьс€ со своими знакомымиї
		driver.findElement(By.xpath("//h2[starts-with(text(),'Facebook')]"));
		//значение атрибута class начинаетс€ с _5iyx
		driver.findElement(By.xpath("//div[starts-with(@class,'_8esj')]"));
		//все ноды, следующие за //input[@id='email']
		driver.findElement(By.xpath("//input[@id='email']/following-sibling::*"));
		//все ноды tr, следующие за //input[@id='email']
	//	driver.findElement(By.xpath("//input[@id='email']/following::tr]"));
	 
	 */
		//все ноды того же уровн€, помимо указанной, т е мес€ц и год, следующие за //select[@id='day']
		driver.findElements(By.xpath("//select[@id='day']/following-sibling::*"));
		//все ноды select/option того же уровн€, следующие за указанной, т е выпадашки мес€ца и года
		driver.findElement(By.xpath("//select[@id='day']/following-sibling::select[1]")).click();
		driver.findElement(By.xpath("//select[@id='day']/following-sibling::select/option[@value='3']"));
		//предшествующие ноды, помимо указанной
		driver.findElement(By.xpath("//input[@id='day']/preceding::*]"));
		//предшествующие ноды select/option, помимо указанной, т е поле ввода email
		driver.findElement(By.xpath("//input[@id='pass']/preceding::input[1]"));
		//предшествующие ноды того же уровн€, помимо указанной, т е дата и мес€ц 
		System.out.println("предшествующие ноды: "+driver.findElement(By.xpath("//select[@id='year']/preceding-sibling::*]")).getAttribute("name"));
		//предшествующие ноды select/option того же уровн€, помимо указанной, т е выпадашки даты  и мес€ца 
		driver.findElement(By.xpath("//select[@id='year']/preceding-sibling::select/option"));	
		
		//xpath дл€ забыл пароль в ‘Ѕ - полный. ненадежно! (начинаетс€ с html)
		// в случае нескольких элементов берет первый
		
	}
}
