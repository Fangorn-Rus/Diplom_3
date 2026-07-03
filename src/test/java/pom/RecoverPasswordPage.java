package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordPage {
    private final WebDriver driver;
    private final By enterURLButton = By.xpath("//a[@href='/login']");
    public RecoverPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Клик по ссылке 'Войти'")
    public void clickEnterURLButton(){        driver.findElement(enterURLButton).click();    }
}
