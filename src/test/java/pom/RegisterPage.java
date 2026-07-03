package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private final WebDriver driver;
    private final By name = By.xpath("//label[text()='Имя']/following-sibling::input");
    private final By email = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By password = By.xpath("//label[text()='Пароль']/following-sibling::input");
    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By enterURLButton  = By.xpath("//a[@href='/login']");
    private final By wrongPasswordMessage = By.xpath("//p[text()='Некорректный пароль']");
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Ввод имени")
    public void setName (String userName) {        driver.findElement(name).sendKeys(userName);    }
    @Step("Ввод email")
    public void setEmail (String userEmail) {
        driver.findElement(email).sendKeys(userEmail);
    }
    @Step("Ввод пароля")
    public void setPassword (String userPassword) {
        driver.findElement(password).sendKeys(userPassword);
    }
    @Step("Клик по кнопке 'Зарегистрироваться'")
    public void clickRegisterButton(){        driver.findElement(registerButton).click();    }
    @Step("Клик по ссылке 'Войти'")
    public void clickEnterURLButton(){        driver.findElement(enterURLButton).click();    }
    @Step("Проверка отображения сообщения о некорректном пароле")
    public boolean checkWrongRegisterStatusWithWrongPassword(){
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(wrongPasswordMessage)).isDisplayed();
    }
}
