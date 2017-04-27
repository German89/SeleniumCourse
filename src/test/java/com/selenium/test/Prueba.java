package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by German on 26/4/2017.
 */
public class Prueba {

    @Test
    public void testGoogle(){
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com.ar");
        driver.findElement(By.id("lst-ib")).sendKeys("Ole");
        driver.findElement( By.cssSelector("[aria-label='Buscar con Google']")).click();
    }
}
