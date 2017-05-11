package com.selenium.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.selenium.automationFramework.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;
import static com.codeborne.selenide.Selenide.$$;
/**
 * Created by German on 24/4/2017.
 */
public class OlePage {
    private WebDriver driver;

    @FindBy(how = How.CSS, using = ".header-top .site-menu li")
    private List<WebElement> headerMenuOptions;

    private By headerMenuLocator = By.cssSelector(".header-top .site-menu li");
    private By clubListLocator = By.cssSelector(".club-list li");

    public OlePage(WebDriver driver) {
        this.driver = driver;
        WaitHelper.waitForPresence(driver, headerMenuLocator, 20);
        PageFactory.initElements(driver, this);
    }

    public List<String> getListOfHeaderMenuOptions(){
        List<String> textList = new ArrayList<String>();
        for (WebElement element : headerMenuOptions) {
            textList.add(element.getText());
        }
        return textList;
    }

    public List<String> getListOfHeaderMenuOptionsSelenided(){
       return  $$(headerMenuLocator).texts();
    }



    public void clickOnMenuOptionSelenium(String optionToClick){
        List<WebElement> listOfOptions = driver.findElements(headerMenuLocator);
        for (WebElement option : listOfOptions) {
            if (option.getText().equals(optionToClick)) {
                option.click();
                break;
            }
        }
    }

    public void clickOnMenuOptionSelenide(String optionToClick){
         $$(clubListLocator).filter(Condition.text(optionToClick)).get(0).click();
    }

}
