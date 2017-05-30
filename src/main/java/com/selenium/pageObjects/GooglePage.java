package com.selenium.pageObjects;

import com.selenium.automationFramework.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by German on 20/4/2017.
 */
public class GooglePage {
    private WebDriver driver;

    //Definicion de las estrategias de busqueda
    private By searchInputLocator = By.name("q");
    private By searchButtonLocator = By.cssSelector("[aria-label='Buscar con Google']");


    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    //Utilizamos los Locator para interactuar con los elementos.
    public void clearText(){
       $(searchInputLocator).clear();
        WaitHelper.sleep(1);
    }

    public void writeTextToSearch(String text){
        $(searchInputLocator).sendKeys(text);
        WaitHelper.sleep(1);
    }

    public ResultsPage clickSearch(){
       $(searchButtonLocator).click();
        return new ResultsPage(driver);
    }

    public ResultsPage pressEnter(){
        $(searchInputLocator).sendKeys(Keys.ENTER);
        return new ResultsPage(driver);
    }
}
