package factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class YandexDriverFactory implements WebDriverFactory{
    @Override
    public WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        return new ChromeDriver(options);
    }
}
