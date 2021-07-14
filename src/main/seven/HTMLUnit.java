package main.seven;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HTMLUnit {
	
	public static void main (String[] args)  throws Exception  {
		SeleniumDriverCases() ;
	}

	@Test(enabled = false)
	public static void SeleniumDriver() {
// выключим предупреждени€ htmlunit, св€занные с его несовершенной работой
	    java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
	    java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);

		WebDriver driver = new  HtmlUnitDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://facebook.com");
		System.out.println("ќткрыто окно с названием "+ driver.getTitle());
		driver.findElement(By.name("email")).sendKeys("dclind@mail.ru");
		driver.findElement(By.name("pass")).sendKeys("vfr4bgt5");
		driver.findElement(By.name("login")).click();
		System.out.println("ќткрыто окно с названием "+ driver.getTitle());
		
		driver.quit();
	}
	
	// варианты запуска драйвера 
	@Test(enabled = false)
	public static void SeleniumDriverCases() {
		WebDriver driver;
		
	// эмулировать FF 60 без javascript 
	 driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_78);
	 ((HtmlUnitDriver) driver).setJavascriptEnabled(false);
	    System.out.println("эмулировать FF 52 без javascript ");
	    
	    
	// эмулировать FF 60 с javascript
	 driver = new HtmlUnitDriver(BrowserVersion.BEST_SUPPORTED, true);
	    System.out.println("эмулировать FF 60 с javascript");
	 
	// без поддержки css
	  driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_78, true) {
		    @Override
		    protected WebClient modifyWebClient(WebClient client) {
		        final WebClient webClient = super.modifyWebClient(client);
		        // you might customize the client here
		        webClient.getOptions().setCssEnabled(false);

		       return webClient;
		    }
		};
	    System.out.println("без поддержки css");
	}
	
	//запустить чистый браузер, без драйвера
	@Test(enabled = false)
	public void homePage() throws Exception {
	    try (final WebClient webClient = new WebClient()) {
	        final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
	        Assert.assertEquals(page.getTitleText(),"HtmlUnit Ц Welcome to HtmlUnit");

	        final String pageAsXml = page.asXml();
	        Assert.assertTrue(pageAsXml.contains("<div id=\"banner\">"));

	        final String pageAsText = page.asText();
	        Assert.assertTrue(pageAsText.contains("Support for the HTTP and HTTPS protocols"));
	    }
	}
	
	
	@Test(enabled = false)
	public void homePage_Firefox() throws Exception {
	    try (final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_78)) {
	        final HtmlPage page = webClient.getPage("https://htmlunit.sourceforge.io/");

	        Assert.assertEquals(page.getTitleText(),"HtmlUnit Ц Welcome to HtmlUnit");
	    }
	}
	
	@Test(enabled = false)
	public static void homePage_proxy() throws Exception {
	    try (final WebClient webClient = new WebClient(BrowserVersion.CHROME, "46.4.96.137", 3128)) {

	        //set proxy username and password 
	  //      final DefaultCredentialsProvider credentialsProvider = (DefaultCredentialsProvider) webClient.getCredentialsProvider();
	  //      credentialsProvider.addCredentials("username", "password");

	        final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
	        Assert.assertEquals(page.getTitleText(),"HtmlUnit Ц Welcome to HtmlUnit");
	    	/*HtmlPage.getFocusedElement()
	    	HtmlPage.tabToNextElement() 
	    	HtmlPage.tabToPreviousElement()
	    	WebAssert.assertAllTabIndexAttributesSet()
	    	HtmlPage.pressAccessKey(char)
	        htmlElement.type(int).KeyboardEvent.DOM_VK_PAGE_DOWN
	    	 */
	    }
	}
	


	

}
