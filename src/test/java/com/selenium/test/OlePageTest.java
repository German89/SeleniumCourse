package com.selenium.test;

import com.selenium.automationFramework.AutomationFramework;
import com.selenium.automationFramework.ResultListener;
import com.selenium.dataProvider.SearchTextProvider;
import org.testng.Assert;
import org.testng.annotations.*;
import com.selenium.pageObjects.GooglePage;
import com.selenium.pageObjects.OlePage;
import com.selenium.pageObjects.ResultsPage;

import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by German on 19/4/2017.
 */


public class OlePageTest extends AutomationFramework {
    private GooglePage googlePage;
    private ResultsPage resultsPage;
    private OlePage olePage;
    private ResultListener resultListener = new ResultListener();

    @BeforeTest
    @Parameters({"browser"})
    public void setUpTest(@Optional("Chrome") String browser) throws InterruptedException, MalformedURLException {
        googlePage = super.setUpSelenide(browser);
        resultListener.getDriver(driver);
    }

    @FirstTest(dataProviderClass = SearchTextProvider.class, dataProvider = "searchTextProvider")
    public void verifyFirstResult(String text) {
        googlePage.clearText();
        googlePage.writeTextToSearch(text);
        resultsPage =  googlePage.pressEnter();
        Assert.assertTrue(resultsPage.getTextOfFirstResult().contains("Ole"), "El primer resultado no contiene la palabra : " + "Ole");
    }

    @FirstTest
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

    @AfterTest
    public void closeBrowser(){
        super.closeBrowser();
    }
}
