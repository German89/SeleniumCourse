package com.selenium.automationFramework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by German on 2/5/2017.
 */
public class AutomationAndroidFramework {

    protected AndroidDriver driver;

    public void setUpNativeAPP() throws InterruptedException, MalformedURLException {
        //Setup Appium
        DesiredCapabilities caps = DesiredCapabilities.android();
        caps.setCapability(MobileCapabilityType.APP, "C:\\drivers\\BitbarSampleApp.apk");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.2.2");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Custom_Phone___4_4_4___API_19___768x1280");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        WaitHelper.setImplicitWait(driver, 10);
    }

    public void setUpHybridApp() throws InterruptedException, MalformedURLException {
        //Setup Appium
        DesiredCapabilities caps = DesiredCapabilities.android();
        caps.setCapability(MobileCapabilityType.APP, "C:\\drivers\\BitbarSampleApp.apk");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"EmulatorMotoX");
        caps.setCapability("platformName", "Android");
        caps.setCapability("VERSION", "4.4.2");
        driver = new AndroidDriver(new URL("http://localhost:4444/wd/hub"), caps);
        Object[] listOfContext = driver.getContextHandles().toArray();
        driver.context(listOfContext[1].toString());

        WaitHelper.setImplicitWait(driver, 10);
    }

    public void closeBrowser(){
        driver.quit();
    }
}
