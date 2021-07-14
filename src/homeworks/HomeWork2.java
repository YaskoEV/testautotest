package homeworks;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWork2 {

	public static void main(String[] args) throws InterruptedException {
		//Задаю объект календарь, для возможности заказа билетов через два месяца от сегодняшней даты
		Calendar calendar = new GregorianCalendar();
        //SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
        //Задаю значения переменным в соответствии с нужной датой (месяц = +2 месяца)
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+3;
        int day = calendar.get(Calendar.DATE);
        
        //System.out.println(year + "." + month + "." + day);
        //Задаю переменный string, для подстановки в код при поиске элементов страницы
        //+Небольшой код для обхода исключений (когда месяц переваливает на следующий год)
        //Год плюс месяц в формате 2021-10
        String strMonth;
        if (month < 10) {
            strMonth = String.valueOf(year) + "-0" + String.valueOf(month);
        } else if (month > 12) {
            strMonth = String.valueOf(year+1) + "-0" + String.valueOf(month-12);
        }else strMonth = String.valueOf(year) + "-" + String.valueOf(month);
        //День, просто сегодняшняя дата
        String strDay = String.valueOf(day);
                       
       //System.out.println(strMonth);
       //System.out.println(strDay);
        //
		System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://www.aviasales.ru/");
		//driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		//Ищу поле города отправления, убираю из него значение по умолчанию - Москва ит задаю свой город
		WebElement departure = driver.findElement(By.xpath("//input[@id='origin']"));
		departure.clear();
		departure.click();
		departure.sendKeys("Омск\t");
		//Ищу поле города назначения и задаю значение
		driver.findElement(By.xpath("//input[@id='destination']")).sendKeys("Москва\t");
		//ищу поле даты вылета и кликаю его, для отображения поля выбора даты
		driver.findElements(By.className("trip-duration__input-wrapper")).get(0).click();
		//нахожу и кликаю на выбор месяца в первой половине окна выбора дат
		WebElement calendar1 = driver.findElements(By.className("calendar-caption__select")).get(0);
		calendar1.click();
		//Задаю переменную типа string пути xPath, для вставки года и месяца
		String strMonthIn = "//option[@value = '" + strMonth + "']";
		//Нахожу нужный месяц и кликаю на него
		driver.findElement(By.xpath(strMonthIn)).click();
		calendar1.click();
		
		//String strDayIn = "//div[@class='calendar-day__date' and text()='" + strDay + "']";
		//нахожу нужну дату (дата вставляется сегодняшняя)
		driver.findElement(By.xpath("//div[@class='calendar-day__date' and text()='" + strDay + "']")).click();
		//кликаю кнопку "Обратный билет не нужен"
		driver.findElements(By.className("button_c1e39c1")).get(0).click();
		//кликаю поле для выбора количества и возраста пассажиров, а так же выбора класса обслуживания
		driver.findElement(By.className("additional-fields__dropdown-container")).click();
		//клик для добавления взрослого
		driver.findElement(By.xpath("//div[@class='additional-fields__passengers-wrap']/div[1]/div[2]/div[2]")).click();
		//клик для добавления ребенка
		driver.findElement(By.xpath("//div[@class='additional-fields__passengers-wrap']/div[2]/div[2]/div[2]")).click();
		//Клик для выбора класса обслуживания Бизнес
		driver.findElement(By.xpath("//div[contains(text(),'Бизнес')]")).click();
		//Клик еще раз в поле для выбора количества и возраста пассажиров, а так же выбора класса обслуживания еще раз, чтобы скрыть выпадашку
		driver.findElement(By.className("additional-fields__dropdown-container")).click();
		
		//получение дескриптора текущей страницы
		String winHandleBefore = driver.getWindowHandle();
		//System.out.println("Title window 1:" + driver.getWindowHandle());
		//клик на кнопку "найти билеты"
		driver.findElement(By.xpath("//div[@class='avia-form__submit']")).click();
		//получение дескриптора новой страницы, чтобы перевести фокус драйвера		
		for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
		//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		//задаем неявное ожидание для драйвера, чтобы ждал элемент
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//System.out.println("Title window 2:" + driver.getWindowHandle());
		//System.out.println("URL:" + driver.getCurrentUrl());
		//кликаем первое предложение (после рекламного)						
		driver.findElements(By.className("ticket-desktop__content")).get(1).click();
		//пара секунд - защита от ненахождения элемента
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[@data-test-element='text' and contains(text(),'Подробнее')]")).click();
		//Alert alert1 = driver.switchTo().alert();
		//клик с поиском кнопки "Подробнее" на вывалившейся форме, чтобы посмотреть уточнения по номеру рейса 
		driver.findElement(By.xpath("//div[contains(text(),'Подробнее')]")).click();
		//System.out.println("Дошли до сюда");
		
		//Thread.sleep(5000);
		//System.out.println("URL:" + driver.getCurrentUrl());
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//получение значения номера рейса и вывод в консоль
		WebElement flight = driver.findElement(By.xpath("//div[@class='ticket-flight-info__head']"));
		System.out.println("Вам подобрали: " + flight.findElement(By.xpath("./div[1]")).getText());
		//WebElement flight = 
		
//		driver.findElement(By.className("title-2-bold"));
		
		System.out.println("Завершение - Ок");
		Thread.sleep(30000);
		driver.quit();
		
		

	}

}
