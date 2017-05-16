package com.selenium.automationFramework;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by German on 24/4/2017.
 */
public class ResultListener extends TestListenerAdapter {
    private static WebDriver driver;

    public void getDriver(WebDriver driver){
        this.driver  = driver;
    }

    @Override
    public void onTestSuccess(ITestResult result){
    }

    @Override
    public void onTestFailure(ITestResult result){

        String fileName = "C:\\screenshotFailedTest\\" + result.getName() + ".jpg";
        Logger.getLogger(Augmenter.class.getName()).setLevel(Level.OFF); //Disable the log of the Augmenter class to avoid warnings while taking screenshots
        final Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
        final BufferedImage image = screenshot.getImage();
        try {
            ImageIO.write(image, "JPG", new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("C:\\screenshotFailedTest\\" + result.getName()+ ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}










/*

 */