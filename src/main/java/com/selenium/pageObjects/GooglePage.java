package com.selenium.pageObjects;

import com.selenium.automationFramework.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * Created by German on 20/4/2017.
 */
public class GooglePage {
    private WebDriver driver;

    //Definicion de las estrategias de busqueda
    private By searchInputLocator = By.name("q");
    private By searchButtonLocator = By.cssSelector("[aria-label='Buscar con Google']");


    //Utilizamos los Locator para interactuar con los elementos.
    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public void writeTextToSearch(String text){
        driver.findElement(searchInputLocator).sendKeys(text);
        WaitHelper.sleep(1);
    }

    public ResultsPage clickSearch(){
        driver.findElement(searchButtonLocator).click();
        WaitHelper.sleep(3);
        return new ResultsPage(driver);
    }

    public ResultsPage pressEnter(){
        driver.findElement(searchInputLocator).sendKeys(Keys.ENTER);
        return new ResultsPage(driver);
    }
}
