package com.selenium.automationFramework;

import com.selenium.pageObjects.GooglePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by AGUIRREG on 27/04/2017.
 */
public class AutomationRemoteFramework {
    protected WebDriver driver;

    public GooglePage setUp(String browser) throws InterruptedException, MalformedURLException {
        if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
            DesiredCapabilities capability = DesiredCapabilities.chrome();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

        } else if (browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver","C:\\drivers\\geckodriver.exe");
            DesiredCapabilities capability = DesiredCapabilities.chrome();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wb/hub"), capability);
        }

        driver.manage().window().maximize();
        driver.get("https://www.google.com.ar");
        WaitHelper.setImplicitWait(driver, 10);
        return new GooglePage(driver);
    }

    public void closeBrowser(){
        driver.quit();
    }

}
