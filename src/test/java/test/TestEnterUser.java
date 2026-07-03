package test;

import api.SetUpAPI;
import api.TestPOMCreateAndDeleteUser;
import api.UserDTO;
import factories.SetUpBrowsers;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.HomePage;
import pom.LoginPage;
import pom.RecoverPasswordPage;
import pom.RegisterPage;

import static org.junit.Assert.assertTrue;

public class TestEnterUser {
    public WebDriver driver;
    TestPOMCreateAndDeleteUser createAndDeleteUser;
    String accessToken;

    private String email;
    private String password;

    @Before
    public void init() {
        SetUpAPI.setUp();
        email = RandomStringUtils.randomAlphabetic(10).toLowerCase() + "@mail.ru";
        password = RandomStringUtils.randomNumeric(8);
        String name = RandomStringUtils.randomAlphabetic(8);

        createAndDeleteUser = new TestPOMCreateAndDeleteUser();
        Response response = createAndDeleteUser.createUser(new UserDTO(email, password, name));
        accessToken = response.path("accessToken");

    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»;")
    public void testEnterUserWithPersonalAccountButton(){
        driver = new SetUpBrowsers().getDriver();
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
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной;")
    public void testEnterUserWithEnterAccountButton(){
        driver = new SetUpBrowsers().getDriver();
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
    @DisplayName("вход через кнопку в форме регистрации;")
    public void testEnterUserWithRegisterForm(){
        driver = new SetUpBrowsers().getDriver();
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
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void testEnterUserWithRecoverPasswordForm(){
        driver = new SetUpBrowsers().getDriver();
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
    public void tearDown() {
        if(accessToken != null){
            TestPOMCreateAndDeleteUser.deleteUser(accessToken);
        }
        driver.quit();    }


}
