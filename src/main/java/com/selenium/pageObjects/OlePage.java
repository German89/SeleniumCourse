package com.selenium.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.selenium.automationFramework.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
/**
 * Created by German on 24/4/2017.
 */
public class OlePage {
    private WebDriver driver;

    @FindBy(css = ".header-top .site-menu li") private List<WebElement> headerMenuOptions;
    @FindBy(css = ".club-list li a") List<WebElement> clubList;


    public OlePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    public List<String> getListOfHeaderMenuOptions(){
        List<String> textList = new ArrayList<String>();
        for (WebElement element : headerMenuOptions) {
            textList.add(element.getText());
        }
        return textList;
    }

    public List<String> getListOfHeaderMenuOptionsSelenide(){
       return  $$(headerMenuOptions).texts();
    }


    public void clickClubSelenium(String optionToClick){
        for (WebElement club : clubList) {
            if (club.getAttribute("data-equipo").equals(optionToClick)) {
                club.click();
                break;
            }
        }
    }

    public void clickClubSelenide(String optionToClick){
         $$(clubList).filter(Condition.attribute("data-equipo", optionToClick)).get(0).click();
    }

}
