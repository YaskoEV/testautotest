package main.seven;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Options {
	static WebDriver driver;
	// отличная статья https://chercher.tech/java/chrome-firefox-options-selenium-webdriver
	public static  WebDriver chromedriver() {
	 ChromeOptions options = new ChromeOptions();
	 	//https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/chrome/ChromeOptions.html
			options.addExtensions(new File("Sudoku.crx"));
			options.setBinary(new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"));
			options.setAcceptInsecureCerts(true);
			
			//профиль Автоматически загружается последний выбранный профиль
			//Для смены профиля надо зайти в менеджер профилей, выбрать профиль и перезагрузить браузер

			
			Proxy prox = new Proxy();
			prox.setProxyAutoconfigUrl("https://proxy.chercher.tech");
			// register the proxy with options class
			options.setProxy(prox);
			
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		    chromePrefs.put("profile.default_content_settings.popups", 0);
		    chromePrefs.put("download.default_directory", "C:\\TestDownloads");
		 // выключить flash и PDF viewer
		    chromePrefs.put("plugins.plugins_disabled", new String[] {
		        "Adobe Flash Player",
		        "Chrome PDF Viewer"
		    });
		    options.setExperimentalOption("prefs", chromePrefs);

		//http://chromedriver.chromium.org/capabilities
			Proxy proxy = new Proxy();
			proxy.setHttpProxy("myhttpproxy:3337");
			options.setCapability("proxy", proxy);	
			options.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));
			
		//https://peter.sh/experiments/chromium-command-line-switches/
			options.addArguments("start-maximized"); 
			options.addArguments("user-data-dir=/path/to/your/custom/profile");

	driver = new ChromeDriver(options);
	return driver;
	}
	
	public WebDriver ffdriver() {
		 FirefoxOptions Foptions = new FirefoxOptions()
				 .setBinary("c:/Program Files/Nightly/firefox.exe")
				 .addArguments("-console")
				 .addPreference("browser.cache.disk.enable", false);
						 
		//proxy
				Proxy proxy = new Proxy();
				proxy.setHttpProxy("myhttpproxy:3337");
				Foptions.setCapability("proxy", proxy);				 
		//профили FF
				ProfilesIni allProfile = new ProfilesIni();
				FirefoxProfile profile = allProfile.getProfile("CertificateIssue");	     
		
		driver = new FirefoxDriver(Foptions);
		return driver;
		}

	public WebDriver IEdriver() {
		InternetExplorerOptions options = new InternetExplorerOptions();
				 
				Proxy proxy = new Proxy();
				proxy.setHttpProxy("myhttpproxy:3337");
				options.setCapability("proxy", proxy);	
				options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

		driver = new InternetExplorerDriver(options);
		return driver;
		}
}
