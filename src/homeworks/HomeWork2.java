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
		//����� ������ ���������, ��� ����������� ������ ������� ����� ��� ������ �� ����������� ����
		Calendar calendar = new GregorianCalendar();
        //SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
        //����� �������� ���������� � ������������ � ������ ����� (����� = +2 ������)
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+3;
        int day = calendar.get(Calendar.DATE);
        
        //System.out.println(year + "." + month + "." + day);
        //����� ���������� string, ��� ����������� � ��� ��� ������ ��������� ��������
        //+��������� ��� ��� ������ ���������� (����� ����� ������������ �� ��������� ���)
        //��� ���� ����� � ������� 2021-10
        String strMonth;
        if (month < 10) {
            strMonth = String.valueOf(year) + "-0" + String.valueOf(month);
        } else if (month > 12) {
            strMonth = String.valueOf(year+1) + "-0" + String.valueOf(month-12);
        }else strMonth = String.valueOf(year) + "-" + String.valueOf(month);
        //����, ������ ����������� ����
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
		
		//��� ���� ������ �����������, ������ �� ���� �������� �� ��������� - ������ �� ����� ���� �����
		WebElement departure = driver.findElement(By.xpath("//input[@id='origin']"));
		departure.clear();
		departure.click();
		departure.sendKeys("����\t");
		//��� ���� ������ ���������� � ����� ��������
		driver.findElement(By.xpath("//input[@id='destination']")).sendKeys("������\t");
		//��� ���� ���� ������ � ������ ���, ��� ����������� ���� ������ ����
		driver.findElements(By.className("trip-duration__input-wrapper")).get(0).click();
		//������ � ������ �� ����� ������ � ������ �������� ���� ������ ���
		WebElement calendar1 = driver.findElements(By.className("calendar-caption__select")).get(0);
		calendar1.click();
		//����� ���������� ���� string ���� xPath, ��� ������� ���� � ������
		String strMonthIn = "//option[@value = '" + strMonth + "']";
		//������ ������ ����� � ������ �� ����
		driver.findElement(By.xpath(strMonthIn)).click();
		calendar1.click();
		
		//String strDayIn = "//div[@class='calendar-day__date' and text()='" + strDay + "']";
		//������ ����� ���� (���� ����������� �����������)
		driver.findElement(By.xpath("//div[@class='calendar-day__date' and text()='" + strDay + "']")).click();
		//������ ������ "�������� ����� �� �����"
		driver.findElements(By.className("button_c1e39c1")).get(0).click();
		//������ ���� ��� ������ ���������� � �������� ����������, � ��� �� ������ ������ ������������
		driver.findElement(By.className("additional-fields__dropdown-container")).click();
		//���� ��� ���������� ���������
		driver.findElement(By.xpath("//div[@class='additional-fields__passengers-wrap']/div[1]/div[2]/div[2]")).click();
		//���� ��� ���������� �������
		driver.findElement(By.xpath("//div[@class='additional-fields__passengers-wrap']/div[2]/div[2]/div[2]")).click();
		//���� ��� ������ ������ ������������ ������
		driver.findElement(By.xpath("//div[contains(text(),'������')]")).click();
		//���� ��� ��� � ���� ��� ������ ���������� � �������� ����������, � ��� �� ������ ������ ������������ ��� ���, ����� ������ ���������
		driver.findElement(By.className("additional-fields__dropdown-container")).click();
		
		//��������� ����������� ������� ��������
		String winHandleBefore = driver.getWindowHandle();
		//System.out.println("Title window 1:" + driver.getWindowHandle());
		//���� �� ������ "����� ������"
		driver.findElement(By.xpath("//div[@class='avia-form__submit']")).click();
		//��������� ����������� ����� ��������, ����� ��������� ����� ��������		
		for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
		//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		//������ ������� �������� ��� ��������, ����� ���� �������
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//System.out.println("Title window 2:" + driver.getWindowHandle());
		//System.out.println("URL:" + driver.getCurrentUrl());
		//������� ������ ����������� (����� ����������)						
		driver.findElements(By.className("ticket-desktop__content")).get(1).click();
		//���� ������ - ������ �� ������������ ��������
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[@data-test-element='text' and contains(text(),'���������')]")).click();
		//Alert alert1 = driver.switchTo().alert();
		//���� � ������� ������ "���������" �� ������������ �����, ����� ���������� ��������� �� ������ ����� 
		driver.findElement(By.xpath("//div[contains(text(),'���������')]")).click();
		//System.out.println("����� �� ����");
		
		//Thread.sleep(5000);
		//System.out.println("URL:" + driver.getCurrentUrl());
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//��������� �������� ������ ����� � ����� � �������
		WebElement flight = driver.findElement(By.xpath("//div[@class='ticket-flight-info__head']"));
		System.out.println("��� ���������: " + flight.findElement(By.xpath("./div[1]")).getText());
		//WebElement flight = 
		
//		driver.findElement(By.className("title-2-bold"));
		
		System.out.println("���������� - ��");
		Thread.sleep(30000);
		driver.quit();
		
		

	}

}
