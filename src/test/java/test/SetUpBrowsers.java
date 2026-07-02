package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetUpBrowsers {
    private WebDriver driver;
    public static final String url = "https://stellarburgers.education-services.ru/";

    public WebDriver getDriver(String browser) {
        return setUp(browser);
    }

    public WebDriver setUp(String browser) {

        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "yandex":
                ChromeOptions yandexOptions = new ChromeOptions();
                System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
                yandexOptions.addArguments("--no-sandbox");
                yandexOptions.addArguments("--headless");
                driver = new ChromeDriver(yandexOptions);
                break;
        }
        return driver;
    }
}
