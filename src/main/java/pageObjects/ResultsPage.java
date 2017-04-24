package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return firstResult.getText();
    }

    public OlePage clickOlePage(){
        firstResult.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new OlePage(driver);
    }



}
