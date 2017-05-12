package com.selenium.test;

import com.selenium.automationFramework.AutomationFramework;
import com.selenium.automationFramework.ResultListener;
import com.selenium.pageObjects.GooglePage;
import com.selenium.pageObjects.OlePage;
import com.selenium.pageObjects.ResultsPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by AGUIRREG on 08/05/2017.
 */
public class FirstOlePageTest extends AutomationFramework {
    private GooglePage googlePage;
    private ResultsPage resultsPage;
    private OlePage olePage;


    @BeforeTest
    public void setUpTest() throws InterruptedException, MalformedURLException {
        //Abrir el browser y navegar hacia la pagina de google
        googlePage = super.setUp("Firefox");
    }

    @Test
    public void verifyFirstResult() {
        //Escribe el texto Ole en el buscador usando el metodo del Page Object
        googlePage.writeTextToSearch("Ole");

        //Presionar el boton Buscar
        resultsPage =  googlePage.pressEnter();

        //Verificar el resultado de la primera busqueda.
        Assert.assertEquals(resultsPage.getTextOfFirstResult(), "Ole | Diario Deportivo");
    }

    @Test(dependsOnMethods = "verifyFirstResult")
    public void verifyOleMenu(){
        //Click en el primer Resultado e instanciar el Page Object olePage
        olePage = resultsPage.clickOlePage();

        //Obtener la lista de elementos del menu y verificar el contenido
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
