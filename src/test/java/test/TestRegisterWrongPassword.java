package test;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pom.HomePage;
import pom.LoginPage;
import pom.RegisterPage;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TestRegisterWrongPassword {
    public WebDriver driver;

    private final String name;
    private final String email;
    private final String password;
    private final String browser;

    public TestRegisterWrongPassword(String name, String email, String password, String browser) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "name: {0}, email: {1}, password: {2}, browser: {3}")
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Vladimir", "mail" + System.currentTimeMillis() + "@mail.ru", "12345", "chrome"},
                {"Alex", "mail" + System.currentTimeMillis() + "@mail.ru", "123", "yandex"}
        };
    }


    @Test
    public void TestSuccessRegister(){
        driver = new SetUpBrowsers().getDriver(browser);
        driver.get(SetUpBrowsers.url);

        HomePage objHomePage = new HomePage(driver);
        RegisterPage objRegisterPage = new RegisterPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);

        objHomePage.clickPersonalAccountButton();
        objLoginPage.clickRegisterURLButton();
        objRegisterPage.setName(name);
        objRegisterPage.setEmail(email);
        objRegisterPage.setPassword(password);
        objRegisterPage.clickRegisterButton();

        assertTrue(objRegisterPage.checkWrongRegisterStatusWithWrongPassword());
    }

    @After
    public void tearDown() {        driver.quit();    }
}
