package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final By email = By.name("name");
    private final By password = By.name("Пароль");
    private final By enterButton = By.xpath("//button[text()='Войти']");
    private final By registerURLButton = By.xpath("//a[@href='/register']");
    private final By recoverPasswordURLButton = By.xpath("//a[@href='/forgot-password']");
    private final By profileField = By.xpath("//a[text()='Профиль']");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Клик по ссылке 'Зарегистрироваться'")
    public void clickRegisterURLButton(){        driver.findElement(registerURLButton).click();    }
    @Step("Ввод email")
    public void setEmail (String userEmail) {
        driver.findElement(email).sendKeys(userEmail);
    }
    @Step("Ввод пароля")
    public void setPassword (String userPassword) {
        driver.findElement(password).sendKeys(userPassword);
    }
    @Step("Клик по кнопке 'Войти'")
    public void clickEnterButton(){        driver.findElement(enterButton).click();    }
    @Step("Клик по ссылке 'Восстановить пароль'")
    public void clickRecoverPasswordURLButton(){        driver.findElement(recoverPasswordURLButton).click();    }
    @Step("Проверка видимости поля 'Профиль'")
    public boolean checkProfileFieldVisible(){
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(profileField)).isDisplayed();
    }
}
