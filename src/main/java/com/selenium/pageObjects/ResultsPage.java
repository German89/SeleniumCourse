package com.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by German on 21/4/2017.
 */
public class ResultsPage {
    private WebDriver driver;

    @FindBy(css = "h3 a") private WebElement firstResult;
    @FindBy(css = ".card-section p") private List<WebElement> relatedSearches;

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
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    public String getTextOfFirstResult(){
       return  firstResult.getText();
    }

    public OlePage clickOlePage(){
        $(firstResult).click();
        return new OlePage(driver);
    }

    public List<String> getRelatedSearchList(){
        List<String> relatedSearchesText = new ArrayList<>();
        for (WebElement element : relatedSearches) {
            relatedSearchesText.add(element.getText());
        }
        return  relatedSearchesText;
    }


}