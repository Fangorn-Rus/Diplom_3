package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By enterAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By bunsButton = By.xpath("//span[text()='Булки']");
    private final By sauceButton = By.xpath("//span[text()='Соусы']");
    private final By fillingButton = By.xpath("//span[text()='Начинки']");
    private final By activeBunsTab = By.xpath("//div[contains(@class, 'tab_tab_type')][.//span[text()='Булки'] and contains(@class, 'tab_tab_type_current__2BEPc')]");
    private final By activeSauceTab = By.xpath("//div[contains(@class, 'tab_tab_type')][.//span[text()='Соусы'] and contains(@class, 'tab_tab_type_current__2BEPc')]");
    private final By activeFillingTab = By.xpath("//div[contains(@class, 'tab_tab_type')][.//span[text()='Начинки'] and contains(@class, 'tab_tab_type_current__2BEPc')]");


    public HomePage(WebDriver driver) {        this.driver = driver;    }
    @Step("Клик по кнопке 'Личный Кабинет'")
    public void clickPersonalAccountButton(){        driver.findElement(personalAccountButton).click();    }
    @Step("Клик по кнопке 'Войти в аккаунт'")
    public void clickEnterAccountButton(){
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(enterAccountButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        }
    @Step("Клик по вкладке 'Булки'")
    public void clickBunsButton(){
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(bunsButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }
    @Step("Клик по вкладке 'Соусы'")
    public void clickSauceButton(){
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(sauceButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }
    @Step("Клик по вкладке 'Начинки'")
    public void clickFillingButton(){
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(fillingButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }
    @Step("Проверка, что активна вкладка 'Булки'")
    public boolean checkBunsTextVisible(){
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(activeBunsTab)).isDisplayed();
    }
    @Step("Проверка, что активна вкладка 'Соусы'")
    public boolean checkSauceTextVisible(){
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(activeSauceTab)).isDisplayed();
    }
    @Step("Проверка, что активна вкладка 'Начинки'")
    public boolean checkFillingTextVisible(){
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(activeFillingTab)).isDisplayed();
    }


}
