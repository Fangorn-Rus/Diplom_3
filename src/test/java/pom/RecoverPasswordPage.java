package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordPage {
    private final WebDriver driver;
    private final By enterURLButton = By.xpath("//a[@href='/login']");
    public RecoverPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickEnterURLButton(){        driver.findElement(enterURLButton).click();    }
}
