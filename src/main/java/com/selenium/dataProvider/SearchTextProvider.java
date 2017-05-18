package com.selenium.dataProvider;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by German on 10/5/2017.
 */
public class SearchTextProvider {

    @DataProvider
    public Object[][] searchProvider() throws IOException {
        //Leer el archivo y agregar a una lista de string cada linea del texto
        BufferedReader  reader = new BufferedReader(new FileReader("C:\\Drivers\\textToSearch.txt"));
        String sCurrentLine;
        List<String> textList = new ArrayList<>();

        while ((sCurrentLine = reader.readLine()) != null) {
            textList.add(sCurrentLine);
        }

        //Pasar al array de Object los datos
        Object[][] textToSearch = new Object[textList.size()][1];
        for (int i = 0 ; i < textList.size(); i++) {
            textToSearch[i][0] = textList.get(i);
        }

        return textToSearch;
    }
}
