package test;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pom.HomePage;
import pom.LoginPage;
import pom.RecoverPasswordPage;
import pom.RegisterPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TestEnterUser {
    public WebDriver driver;

    private final String email;
    private final String password;
    private final String browser;

    public TestEnterUser(String email, String password, String browser) {
        this.email = email;
        this.password = password;
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "email: {0}, password: {1}, browser: {2}")
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Alex","test321test@mail.ru", "123456", "chrome"},
                {"Vladimir","test333321test@mail.ru", "ffffffffffff", "yandex"}
        };
    }

    @Test
    public void TestEnterUserWithPersonalAccountButton(){
        driver = new SetUpBrowsers().getDriver(browser);
        driver.get(SetUpBrowsers.url);

        HomePage objHomePage = new HomePage(driver);
        LoginPage objLoginPage = new LoginPage(driver);

        objHomePage.clickPersonalAccountButton();

        objLoginPage.setEmail(email);
        objLoginPage.setPassword(password);
        objLoginPage.clickEnterButton();

        objHomePage.clickPersonalAccountButton();
        assertTrue(objLoginPage.checkProfileFieldVisible());

    }

    @Test
    public void TestEnterUserWithEnterAccountButton(){
        driver = new SetUpBrowsers().getDriver(browser);
        driver.get(SetUpBrowsers.url);

        HomePage objHomePage = new HomePage(driver);
        LoginPage objLoginPage = new LoginPage(driver);

        objHomePage.clickEnterAccountButton();

        objLoginPage.setEmail(email);
        objLoginPage.setPassword(password);
        objLoginPage.clickEnterButton();

        objHomePage.clickPersonalAccountButton();
        assertTrue(objLoginPage.checkProfileFieldVisible());
    }

    @Test
    public void TestEnterUserWithRegisterForm(){
        driver = new SetUpBrowsers().getDriver(browser);
        driver.get(SetUpBrowsers.url);

        HomePage objHomePage = new HomePage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        RegisterPage objRegisterPage = new RegisterPage(driver);

        objHomePage.clickPersonalAccountButton();
        objLoginPage.clickRegisterURLButton();
        objRegisterPage.clickEnterURLButton();

        objLoginPage.setEmail(email);
        objLoginPage.setPassword(password);
        objLoginPage.clickEnterButton();

        objHomePage.clickPersonalAccountButton();
        assertTrue(objLoginPage.checkProfileFieldVisible());
    }

    @Test
    public void TestEnterUserWithRecoverPasswordForm(){
        driver = new SetUpBrowsers().getDriver(browser);
        driver.get(SetUpBrowsers.url);

        HomePage objHomePage = new HomePage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        RecoverPasswordPage objRecoverPasswordPage = new RecoverPasswordPage(driver);

        objHomePage.clickPersonalAccountButton();
        objLoginPage.clickRecoverPasswordURLButton();
        objRecoverPasswordPage.clickEnterURLButton();

        objLoginPage.setEmail(email);
        objLoginPage.setPassword(password);
        objLoginPage.clickEnterButton();

        objHomePage.clickPersonalAccountButton();
        assertTrue(objLoginPage.checkProfileFieldVisible());
    }

    @After
    public void tearDown() {        driver.quit();    }


}
