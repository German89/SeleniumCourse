package com.selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

/**
 * Created by German on 21/4/2017.
 */
public class ResultsPage {
    private WebDriver driver;


    @FindBy(how = How.CSS, using = ".rc a")
    private WebElement firstResult;

    @FindBys({
            @FindBy (how = How.ID, using = "id"),
            @FindBy (how = How.CLASS_NAME, using = "class")
    })
    private List<WebElement> listOfElements;

    @FindAll({
            @FindBy (how = How.ID, using = "id"),
            @FindBy (how = How.CLASS_NAME, using = "class")
    })
    private List<WebElement> elements;

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTextOfFirstResult(){
        return firstResult.getText();
    }

    public OlePage clickOlePage(){
        firstResult.click();
        return new OlePage(driver);
    }



}
