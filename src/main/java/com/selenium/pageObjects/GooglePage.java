package com.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by German on 20/4/2017.
 */
public class GooglePage {
    private WebDriver driver;

    //Definicion de las estrategias de busqueda
    private By searchInputLocator = By.id("lst-ib");
    private By searchButtonLocator = By.cssSelector("[aria-label='Buscar con Google']");


    //Utilizamos los Locator para interactuar con los elementos.
    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public void writeTextToSearch(String text){
        driver.findElement(searchInputLocator).sendKeys(text);
    }

    public ResultsPage clickSearch(){
        driver.findElement(searchButtonLocator).click();
        return new ResultsPage(driver);
    }
}
