package com.selenium.test;

import com.selenium.automationFramework.AutomationFramework;
import com.selenium.automationFramework.ResultListener;
import org.testng.Assert;
import org.testng.annotations.*;
import com.selenium.pageObjects.GooglePage;
import com.selenium.pageObjects.ResultsPage;

/**
 * Created by AGUIRREG on 25/04/2017.
 */
public class FacebookPageTest extends AutomationFramework{
    private GooglePage googlePage;
    private ResultsPage resultsPage;
    private ResultListener resultListener = new ResultListener();

    @BeforeTest
    @Parameters("browser")
    public void setUpBrowser( String browser) throws InterruptedException {
        googlePage = super.setUp(browser);
        resultListener.getDriver(driver);
    }

    @Test
    public void verifyFirstResultFacebook() {
        googlePage.writeTextToSearch("Facebook");
        resultsPage =  googlePage.clickSearch();
        Assert.assertEquals(resultsPage.getTextOfFirstResult(), "Facebook - Inicia sesión o regístrate" );
    }

    @AfterTest
    public void closeBrowser(){
        super.closeBrowser();
    }
}
