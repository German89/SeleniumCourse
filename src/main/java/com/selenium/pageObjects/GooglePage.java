package com.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by German on 20/4/2017.
 */
public class GooglePage {
    private WebDriver driver;

    private By searchInput = By.id("lst-ib");
    private By searchButton = By.cssSelector("[aria-label='Buscar con Google']");

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public void writeTextToSearch(String text){
        driver.findElement(searchInput).sendKeys(text);
    }

    public ResultsPage clickSearch(){
        driver.findElement(searchButton).click();
        return new ResultsPage(driver);
    }
}
