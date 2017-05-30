package com.selenium.test;

import com.codeborne.selenide.testng.TextReport;
import com.codeborne.selenide.testng.annotations.Report;
import com.selenium.automationFramework.AutomationFramework;
import com.selenium.automationFramework.WaitHelper;
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
@Listeners(TextReport.class)
@Report
public class OlePageTest extends AutomationFramework {
    private GooglePage googlePage;
    private ResultsPage resultsPage;
    private OlePage olePage;

    @BeforeTest
    public void setUpTest() throws InterruptedException, MalformedURLException {
        googlePage = super.setUp("Remote_Chrome");
    }

    @Test
    public void verifyFirstResult() {
        googlePage.clearText();
        googlePage.writeTextToSearch("Ole");
        resultsPage =  googlePage.pressEnter();
        Assert.assertTrue(resultsPage.getTextOfFirstResult().contains("Ole"), "El primer resultado no contiene la palabra : Ole Se encontró: " + resultsPage.getTextOfFirstResult());
    }

    @Test(dependsOnMethods = "verifyFirstResult")
    public void verifyOleMenu(){
        olePage = resultsPage.clickOlePage();
        List<String> menuElements = olePage.getListOfHeaderMenuOptionsSelenide();
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

    @Test(dependsOnMethods = "verifyOleMenu")
    public void VerifyClubInformation(){
        olePage.clickClubSelenide("Arsenal");
        Assert.assertEquals(olePage.getClubHeaderTitle(), "Arsenal");
    }

    @AfterTest
    public void closeBrowser(){
        super.closeBrowser();
    }
}
