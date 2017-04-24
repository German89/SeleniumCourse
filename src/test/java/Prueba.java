import automationFramework.Driver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.GooglePage;
import pageObjects.OlePage;
import pageObjects.ResultsPage;

import java.io.IOException;
import java.util.List;

/**
 * Created by German on 19/4/2017.
 */

public class Prueba {
    private GooglePage googlePage;
    private Driver driver;
    private ResultsPage resultsPage;
    private OlePage olePage;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new Driver();
        googlePage = driver.setUp("Chrome");
    }

    @Test
    public void verifyFirstResult() {
        googlePage.writeTextToSearch("Ole");
        resultsPage =  googlePage.clickSearch();
        Assert.assertEquals("Ole | Diario Deportivo", resultsPage.getTextOfFirstResult());
    }

    @Test(dependsOnMethods = {"verifyFirstResult"})
    public void verifyOleMenu(){
        olePage = resultsPage.clickOlePage();
        List<String> menuElements = olePage.getListOfHeaderMenuOptions();
        Assert.assertTrue(menuElements.contains("PRIMERA"), " La opcion Primera, no aparece en el menu");
        Assert.assertTrue(menuElements.contains("ASCENSO"), " La opcion ASCENSO, no aparece en el menu");
        Assert.assertTrue(menuElements.contains("INTERNACIONAL"), " La opcion INTERNACIONAL, no aparece en el menu");
        Assert.assertTrue(menuElements.contains("SELECCION"), " La opcion SELECCION, no aparece en el menu");
        Assert.assertTrue(menuElements.contains("MESSI"), " La opcion MESSI, no aparece en el menu");
        Assert.assertTrue(menuElements.contains("BASQUET"), " La opcion BASQUET, no aparece en el menu");
        Assert.assertTrue(menuElements.contains("TENIS"), " La opcion TENIS, no aparece en el menu");
        Assert.assertTrue(menuElements.contains("VOLEY"), " La opcion VOLEY, no aparece en el menu");
        Assert.assertTrue(menuElements.contains("AUTOS"), " La opcion AUTOS, no aparece en el menu");
        Assert.assertTrue(menuElements.contains("DIOSAS"), " La opcion DIOSAS, no aparece en el menu");
        Assert.assertTrue(menuElements.contains("MAS"), " La opcion MAS, no aparece en el menu");
        Assert.assertEquals(menuElements.size(), 11);
    }

    @AfterMethod
    public void takeScreenshotFailedTest(ITestResult iTestResult) throws IOException {
        if (!iTestResult.isSuccess()) {
            driver.takeScreenshot(iTestResult.getTestName());
        }
    }

    @AfterTest
    public void closeBrowser(){
        driver.closeBrowser();
    }
}
