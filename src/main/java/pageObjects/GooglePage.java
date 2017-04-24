package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(searchInput));
        driver.findElement(searchInput).sendKeys(text);
    }

    public ResultsPage clickSearch(){
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(searchButton));
        driver.findElement(searchButton).click();
        return new ResultsPage(driver);
    }
    
}
