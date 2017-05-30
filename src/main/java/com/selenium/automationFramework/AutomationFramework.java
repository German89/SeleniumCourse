package com.selenium.automationFramework;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.TextReport;
import com.codeborne.selenide.testng.annotations.Report;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import com.selenium.pageObjects.GooglePage;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by German on 20/4/2017.
 */

public class AutomationFramework {
    protected WebDriver driver;
    private ResultListener resultListener = new ResultListener();


    protected GooglePage setUp(String browser) throws InterruptedException, MalformedURLException {
        if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver","C:\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        else if(browser.equals("Remote_PhantomJS")) {
            DesiredCapabilities caps = DesiredCapabilities.phantomjs();
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\drivers\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
        }

        else if(browser.equals("Remote_Chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
            DesiredCapabilities capability = DesiredCapabilities.chrome();
            capability.setCapability("aplicationName", "pc1");
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
        }

        WebDriverRunner.setWebDriver(driver);//Selenide is going to use the selenium webdriver
        driver.manage().window().maximize();
        driver.get("https://www.google.com.ar");
        WaitHelper.setImplicitWait(driver, 5);
        resultListener.getDriver(driver);
        return new GooglePage(driver);
    }


    protected void closeBrowser(){
        driver.quit();
    }
}
