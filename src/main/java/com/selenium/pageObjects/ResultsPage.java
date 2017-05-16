package com.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

/**
 * Created by German on 21/4/2017.
 */
public class ResultsPage {
    private WebDriver driver;

    @FindBy(css = "h3 a")
    private WebElement firstResult;

    @FindBys({
            @FindBy (className = "class"),
            @FindBy (css = "[visible = 'block']")
    })
    private List<WebElement> listOfElements;

    @FindAll({
            @FindBy (id = "id"),
            @FindBy (className = "class")
    })
    private List<WebElement> elements;

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTextOfFirstResult(){
       return  firstResult.getText();
    }

    public OlePage clickOlePage(){
        firstResult.click();
        return new OlePage(driver);
    }
}