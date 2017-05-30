package com.selenium.test;

import com.selenium.automationFramework.AutomationAndroidFramework;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

/**
 * Created by German on 2/5/2017.
 */
public class BitBarTest extends AutomationAndroidFramework {

    @BeforeClass
    public void setUp() throws MalformedURLException, InterruptedException {
        super.setUpNativeAPP();

    }
    @Test
    public void appiumBitBarTest() {
        //Click second radio button
        driver.findElement(By.xpath("//*[@text='Use Testdroid Cloud']")).click();
        //Write Testing! to the text area
        driver.findElement(By.className("android.widget.EditText")).sendKeys("Testing!");
        //Hide Keyboard
        driver.hideKeyboard();
        //Click Answer Button
        driver.findElement(By.xpath("//*[@text='Answer']")).click();
        //Synchronization after click and check the expected text
        Assert.assertEquals("Congratulations Testing!!" , driver.findElement(By.xpath("//*[@text='Congratulations Testing!!']")).getText());
    }

    @AfterClass
    public void teardown(){
        //Teardown operation
        driver.quit();
    }
}
