package com.selenium.automationFramework;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.TextReport;
import com.codeborne.selenide.testng.annotations.Report;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Listeners;
import com.selenium.pageObjects.GooglePage;

/**
 * Created by German on 20/4/2017.
 */
@Listeners({ResultListener.class})
@Report
public class AutomationFramework {
    protected WebDriver driver;

    protected GooglePage setUp(String browser) throws InterruptedException {
        if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver","C:\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        else if(browser.equals("PhantomJS")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\Drivers\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
            driver = new PhantomJSDriver(caps);
        }

        driver.manage().window().maximize();
        driver.get("https://www.google.com.ar");
        WaitHelper.setImplicitWait(driver, 20);
        return new GooglePage(driver);
    }

    protected  GooglePage setUpSelenide(String browser) throws InterruptedException {
        if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver","C:\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        WebDriverRunner.setWebDriver(driver);//Selenide is going to use the selenium webdriver
        driver.manage().window().maximize();
        driver.get("https://www.google.com.ar");
        WaitHelper.setImplicitWait(driver, 10);
        return new GooglePage(driver);
    }


    protected void closeBrowser(){
        driver.quit();
    }
}
