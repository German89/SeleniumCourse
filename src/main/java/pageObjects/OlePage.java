package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by German on 24/4/2017.
 */
public class OlePage {
    private WebDriver driver;

    @FindBy(how = How.CSS, using = ".header-top .site-menu li")
    private List<WebElement> headerMenuOptions;

    public OlePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<String> getListOfHeaderMenuOptions(){
        List<String> textList = new ArrayList<String>();
        for (WebElement element : headerMenuOptions) {
            textList.add(element.getText());
        }
        return textList;
    }
}
