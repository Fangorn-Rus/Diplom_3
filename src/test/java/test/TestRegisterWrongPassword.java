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
import pom.RegisterPage;
import static org.junit.Assert.assertTrue;

public class TestRegisterWrongPassword {
    public WebDriver driver;
    TestPOMCreateAndDeleteUser createAndDeleteUser;
    String accessToken;

    private String name;
    private String email;
    private String password;

    @Before
    public void init() {
        SetUpAPI.setUp();
        email = RandomStringUtils.randomAlphabetic(10).toLowerCase() + "@mail.ru";
        password = RandomStringUtils.randomNumeric(5);
        name = RandomStringUtils.randomAlphabetic(8);

        createAndDeleteUser = new TestPOMCreateAndDeleteUser();
        Response response = createAndDeleteUser.createUser(new UserDTO(email, password, name));
        accessToken = response.path("accessToken");
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля. Минимальный пароль — шесть символов.")
    public void testSuccessRegister(){
        driver = new SetUpBrowsers().getDriver();
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
    public void tearDown() {
        if(accessToken != null){
            TestPOMCreateAndDeleteUser.deleteUser(accessToken);
        }
        driver.quit();
    }
}
