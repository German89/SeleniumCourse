package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.GooglePage;

/**
 * Created by German on 20/4/2017.
 */
public class Driver {
    private WebDriver driver;

    public  GooglePage setUp(String browser) throws InterruptedException {
        if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.get("https://www.google.com.ar");
        Thread.sleep(5000);
        return new GooglePage(driver);
    }

    public void closeBrowser(){
        driver.quit();
    }

}
