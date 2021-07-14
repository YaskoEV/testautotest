package main.seven;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import static org.junit.Assert.*;
import java.io.File;

public class piscCompare {

    public enum Result { Matched, SizeMismatch, PixelMismatch };
    
    static Result CompareImage(String baseFile, String actualFile) {
        Result compareResult = Result.PixelMismatch;
        Image baseImage = Toolkit.getDefaultToolkit().getImage(baseFile);
        Image actualImage = Toolkit.getDefaultToolkit().
        getImage(actualFile);
        try {
            PixelGrabber baseImageGrab = new PixelGrabber(baseImage, 0, 0, -1, -1, false);
            PixelGrabber actualImageGrab = new PixelGrabber(actualImage, 0, 0, -1, -1, false);
            int[] baseImageData = null;
            int[] actualImageData = null;
            if(baseImageGrab.grabPixels()) {
                int width = baseImageGrab.getWidth();
                int height = baseImageGrab.getHeight();
                baseImageData = new int[width * height];
                baseImageData = (int[])baseImageGrab.getPixels();
            }
            if(actualImageGrab.grabPixels()) {
                int width = actualImageGrab.getWidth();
                int height = actualImageGrab.getHeight();
                actualImageData = new int[width * height];
                actualImageData = (int[])actualImageGrab.getPixels();
            }
            System.out.println(baseImageGrab.getHeight() + "<>" +
            actualImageGrab.getHeight());
            System.out.println(baseImageGrab.getWidth() + "<>" +
            actualImageGrab.getWidth());
            if ((baseImageGrab.getHeight() != actualImageGrab.getHeight()) || (baseImageGrab.getWidth() != actualImageGrab.getWidth())){
                compareResult = Result.SizeMismatch;
            }
            else if(java.util.Arrays.equals(baseImageData,actualImageData)){
                compareResult = Result.Matched;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return compareResult;
    }
    
    
    public WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", ".//drivers//FFdriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void imageCompareTest() throws Exception {
        String scrFile = "FILE_PATH";
        String baseScrFile = "BASE_FILE_PATH";
        // Заходим на страницу
        driver.get("http://lenta.ru");
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(scrFile));
        try {
            //Сравниваем изображение с базовым
            assertEquals(piscCompare.Result.Matched, piscCompare.CompareImage(baseScrFile, scrFile));
        } catch (Error e) {
            // Сохраняем ошибки в переменную
            verificationErrors.append(e.toString());
        }
    }

    @After
    public void tearDown() throws Exception {
        //Закрываем браузер
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
    
    
}