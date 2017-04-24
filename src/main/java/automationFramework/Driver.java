package automationFramework;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.GooglePage;

import java.io.File;
import java.io.IOException;

/**
 * Created by German on 20/4/2017.
 */
public class Driver {
    private WebDriver driver;

    public  GooglePage setUp(String browser) throws InterruptedException {
        if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver","C:\\drivers\\geckodriver.exe");
          //  DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.get("https://www.google.com.ar");
        Thread.sleep(5000);
        return new GooglePage(driver);
    }

    public void takeScreenshot(String testName) throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\\screenshotFailedTest\\" + testName + ".png"));
    }

    public void closeBrowser(){
        driver.quit();
    }
}
