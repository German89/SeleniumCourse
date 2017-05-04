package com.selenium.automationFramework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
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
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"EmulatorMotoX");
        caps.setCapability("platformName", "Android");
        caps.setCapability("VERSION", "4.4.2");
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
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        String webViewContext = driver.getContextHandles().toArray()[1].toString();
        driver.context(webViewContext);

        WaitHelper.setImplicitWait(driver, 10);
    }

    public void closeBrowser(){
        driver.quit();
    }

}
