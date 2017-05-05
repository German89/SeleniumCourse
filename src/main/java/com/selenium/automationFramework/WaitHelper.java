package com.selenium.automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by AGUIRREG on 25/04/2017.
 */
public class WaitHelper {

    public static void waitForPresence(WebDriver driver, By locator, int timeout){
        (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void setImplicitWait(WebDriver driver, int seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
}
