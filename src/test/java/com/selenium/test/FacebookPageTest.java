package com.selenium.test;

import com.selenium.automationFramework.AutomationFramework;
import com.selenium.automationFramework.ResultListener;
import org.testng.Assert;
import org.testng.annotations.*;
import com.selenium.pageObjects.GooglePage;
import com.selenium.pageObjects.ResultsPage;

import java.net.MalformedURLException;

/**
 * Created by AGUIRREG on 25/04/2017.
 */
public class FacebookPageTest extends AutomationFramework {
    private GooglePage googlePage;
    private ResultsPage resultsPage;
    private ResultListener resultListener = new ResultListener();

    @BeforeClass
    @Parameters("browser")
    public void setUpBrowser(@Optional("Chrome")  String browser) throws InterruptedException, MalformedURLException {
        googlePage = super.setUp(browser);
    }

    @Test
    @Parameters("testRailId")
    public void verifyFirstResultFacebook(@Optional("1001") String id) {
        googlePage.writeTextToSearch("Facebook");
        resultsPage =  googlePage.clickSearch();
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser(){
        super.closeBrowser();
    }
}
