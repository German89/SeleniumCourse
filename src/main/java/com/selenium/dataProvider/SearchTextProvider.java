package com.selenium.dataProvider;

import org.testng.annotations.DataProvider;

/**
 * Created by German on 10/5/2017.
 */
public class SearchTextProvider {

    @DataProvider
    public Object[][] searchTextProvider(){
        return new Object[][]{{"Ole1"}, {"Ole2"}};
    }
}
