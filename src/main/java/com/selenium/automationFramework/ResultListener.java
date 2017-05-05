package com.selenium.automationFramework;

import com.codeborne.selenide.WebDriverRunner;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;

/**
 * Created by German on 24/4/2017.
 */
public class ResultListener extends TestListenerAdapter{
    private static WebDriver driver;

    public void getDriver(WebDriver driver){
        this.driver  = driver;
    }

    @Override
    public void onTestSuccess(ITestResult result){
    }

    @Override
    public void onTestFailure(ITestResult result){
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("C:\\screenshotFailedTest\\" + result.getTestName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
