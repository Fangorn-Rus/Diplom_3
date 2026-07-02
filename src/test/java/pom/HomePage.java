package pom;

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
    private final By bunsText = By.xpath("//h2[text()='Булки']");
    private final By sauceText = By.xpath("//h2[text()='Соусы']");
    private final By fillingText = By.xpath("//h2[text()='Начинки']");


    public HomePage(WebDriver driver) {        this.driver = driver;    }

    public void clickPersonalAccountButton(){        driver.findElement(personalAccountButton).click();    }

    public void clickEnterAccountButton(){
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(enterAccountButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        }
    public void clickBunsButton(){
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(bunsButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        //driver.findElement(bunsButton).click();
    }
    public void clickSauceButton(){
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(sauceButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
       // driver.findElement(sauceButton).click();
    }
    public void clickFillingButton(){
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(fillingButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        //driver.findElement(fillingButton).click();
    }

    public boolean checkBunsTextVisible(){
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(bunsText)).isDisplayed();
    }

    public boolean checkSauceTextVisible(){
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(sauceText)).isDisplayed();
    }

    public boolean checkFillingTextVisible(){
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(fillingText)).isDisplayed();
    }


}
