package com.selenium.pageObjects;

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

    @FindBy(how = How.CSS, using = "h3 a")
    private WebElement firstResult;

    @FindBys({
            @FindBy (how = How.CLASS_NAME, using = "class"),
            @FindBy (how = How.CSS, using = "[visible = 'true']")
    })
    private List<WebElement> listOfElements;

    @FindAll({
            @FindBy (how = How.ID, using = "id"),
            @FindBy (how = How.CLASS_NAME, using = "class")
    })
    private List<WebElement> elements;

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    public String getTextOfFirstResult(){
        return firstResult.getText();
    }

    public OlePage clickOlePage(){
        firstResult.click();
        return new OlePage(driver);
    }
}
