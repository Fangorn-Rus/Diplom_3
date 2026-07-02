package test;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pom.HomePage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TestConstructor {
    public WebDriver driver;
    private final String browser;

    public TestConstructor(String browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "browser: {0}")
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"chrome"},
                {"yandex"}
        };
    }

    @Test
    public void TestCheckSectionTransitionsWorkingBuns(){
        driver = new SetUpBrowsers().getDriver(browser);
        driver.get(SetUpBrowsers.url);

        HomePage objHomePage = new HomePage(driver);

        objHomePage.clickFillingButton();
        objHomePage.clickBunsButton();
        assertTrue(objHomePage.checkBunsTextVisible());

    }

    @Test
    public void TestCheckSectionTransitionsWorkingFilling(){
        driver = new SetUpBrowsers().getDriver(browser);
        driver.get(SetUpBrowsers.url);

        HomePage objHomePage = new HomePage(driver);

        objHomePage.clickFillingButton();
        assertTrue(objHomePage.checkFillingTextVisible());
    }

    @Test
    public void TestCheckSectionTransitionsWorkingSauce(){
        driver = new SetUpBrowsers().getDriver(browser);
        driver.get(SetUpBrowsers.url);

        HomePage objHomePage = new HomePage(driver);

        objHomePage.clickSauceButton();
        assertTrue(objHomePage.checkSauceTextVisible());

    }

    @After
    public void tearDown() {        driver.quit();    }

}
