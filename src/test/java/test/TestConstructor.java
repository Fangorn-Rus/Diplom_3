package test;

import factories.SetUpBrowsers;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.HomePage;

import static org.junit.Assert.assertTrue;

public class TestConstructor {
    public WebDriver driver;


    @Test
    @DisplayName("работают переходы к разделам «Булки»")
    public void testCheckSectionTransitionsWorkingBuns(){
        driver = new SetUpBrowsers().getDriver();
        driver.get(SetUpBrowsers.url);
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickFillingButton();
        objHomePage.clickBunsButton();
        assertTrue(objHomePage.checkBunsTextVisible());
    }

    @Test
    @DisplayName("работают переходы к разделам «Начинки»")
    public void testCheckSectionTransitionsWorkingFilling(){
        driver = new SetUpBrowsers().getDriver();
        driver.get(SetUpBrowsers.url);

        HomePage objHomePage = new HomePage(driver);

        objHomePage.clickFillingButton();
        assertTrue(objHomePage.checkFillingTextVisible());
    }

    @Test
    @DisplayName("работают переходы к разделам «Соусы»")
    public void testCheckSectionTransitionsWorkingSauce(){
        driver = new SetUpBrowsers().getDriver();
        driver.get(SetUpBrowsers.url);

        HomePage objHomePage = new HomePage(driver);

        objHomePage.clickSauceButton();
        assertTrue(objHomePage.checkSauceTextVisible());

    }

    @After
    public void tearDown() {        driver.quit();    }

}
