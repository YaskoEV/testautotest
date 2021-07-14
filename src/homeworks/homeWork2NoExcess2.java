package homeworks;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

 


public class homeWork2NoExcess2 {
	
	public static void main(String[] args) throws InterruptedException {
		//����� ������ ���������, ��� ����������� ������ ������� ����� ��� ������ �� ����������� ����
		Calendar calendar = new GregorianCalendar();
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
                       
		System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.aviasales.ru/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
		//������ ����� ���� (���� ����������� �����������)
		driver.findElement(By.xpath("//div[@class='calendar-day__date' and text()='" + strDay + "']")).click();
		//������ ������ "�������� ����� �� �����"
		driver.findElement(By.xpath("//div[@class='trip-duration__content-head']")).click();
		//driver.findElements(By.className("button_c1e39c1")).get(0).click();
		//������ ���� ��� ������ ���������� � �������� ����������, � ��� �� ������ ������ ������������
		driver.findElement(By.className("additional-fields__dropdown-container")).click();
		Thread.sleep(1500);
		//���� ��� ���������� ���������
		driver.findElement(By.xpath("//div[@class='additional-fields__passengers-wrap']/div[1]/div[2]/div[2]")).click();
		//���� ��� ���������� �������
		driver.findElement(By.xpath("//div[@class='additional-fields__passengers-wrap']/div[2]/div[2]/div[2]")).click();
		//���� ��� ������ ������ ������������ ������
		driver.findElement(By.xpath("//div[contains(text(),'������')]")).click();
		//���� ��� ��� � ���� ��� ������ ���������� � �������� ����������, � ��� �� ������ ������ ������������ ��� ���, ����� ������ ���������
		
		try {
			WebElement doubleClick;
			doubleClick = driver.findElement(By.className("additional-fields__dropdown-container"));
			doubleClick.click();
			System.out.println("������� 1");
		} catch (Exception e) {
			// TODO: handle exception
			WebElement doubleClick;
			doubleClick = driver.findElement(By.xpath("//header/button[1]"));
			doubleClick.click();
			System.out.println("������� 2");
		} 
		/*
		 * WebElement closeBut = driver.findElement(By.xpath("//header/button[1]"));
		 * String clBt = closeBut.getTagName(); if (clBt.equals("button")) {
		 * closeBut.click(); }else
		 */
		//doubleClick.findElement(By.className("additional-fields__dropdown-container"));
		
		
		//��������� ����������� ������� �������� 
		//String winHandleBefore = driver.getWindowHandle();
		//System.out.println("Title window 1:" + driver.getWindowHandle() + driver.getCurrentUrl());

		//���� �� ������ "����� ������"
		driver.findElement(By.xpath("//div[@class='avia-form__submit']")).click();
		//��������� ����������� ����� ��������, ����� ��������� ����� ��������		
		for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
		//System.out.println("Title window 2:" + driver.getWindowHandle() + driver.getCurrentUrl());
		//������ ������� �������� ��� ��������, ����� ���� �������
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		/*
		 * for(String winHandle : driver.getWindowHandles()){
		 * driver.switchTo().window(winHandle); }
		 */
		System.out.println("Title window 2:" + driver.getWindowHandle() + driver.getCurrentUrl());
		//������� ������ ����������� (����� ����������)		
		//driver.findElements(By.xpath("//button[@class='ticket-desktop__expand-button']")).get(1).click();
		//WebElement but = driver.findElements(By.className("ticket-desktop__expand-button")).get(1);
		if(driver.findElements(By.xpath("//button[@class='ticket-desktop__expand-button']")).size() == 1) {
			driver.findElement(By.xpath("//button[@class='ticket-desktop__expand-button']")).click();
		} else driver.findElements(By.xpath("//button[@class='ticket-desktop__expand-button']")).get(1).click();
		System.out.println(driver.findElements(By.xpath("//button[@class='ticket-desktop__expand-button']")).size());
		

		
		//���� ������ - ������ �� ������������ ��������
		Thread.sleep(2000);
		
		//���� � ������� ������ "���������" �� ������������ �����, ����� ���������� ��������� �� ������ ����� 
		//driver.findElement(By.xpath("//div[contains(text(),'���������')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'���������')]")).click();

		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//��������� �������� ������ ����� � ����� � �������
		WebElement flight = driver.findElement(By.xpath("//div[@class='ticket-flight-info__head']"));
		System.out.println("��� ���������: " + flight.findElement(By.xpath("./div[1]")).getText());

		System.out.println("���������� - ��");
		Thread.sleep(10000);
		driver.quit();
		
		

	}


}
