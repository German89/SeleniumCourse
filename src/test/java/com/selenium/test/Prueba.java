package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by German on 26/4/2017.
 */
public class Prueba {

    @Test
    public void testGoogle(){
        //Le indicamos a Selenium que vamos a ejecutar nuestros test en Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Navegamos a la pagina de Google
        driver.get("http://www.google.com.ar");

        // Localizamos por ID el elemento input y lo guardamos en un Objeto del tipo WebElement
        WebElement inputBusqueda = driver.findElement(By.name("q"));

        //Escribimos el texto Ole en el input
        inputBusqueda.sendKeys("Ole");

        //Localizamos el boton de buscar usando un selector css y le hacemos click
        driver.findElement(By.cssSelector("[aria-label='Buscar con Google']")).click();
    }

    @DataProvider(name = "textToSearch")
    public Object[][] textToSearch(){
        return new Object[][]{{"Ole1", "Ole2"}};
    }
}
