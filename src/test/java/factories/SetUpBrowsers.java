package factories;

import org.openqa.selenium.WebDriver;

public class SetUpBrowsers {
    public static final String url = "https://stellarburgers.education-services.ru/";

    public WebDriver getDriver() {
        String browserType = System.getProperty("browser", "chrome");
        WebDriverFactory factory = createFactory(browserType);
        return factory.createDriver();
    }

    private WebDriverFactory createFactory(String browserType) {
        switch (browserType.toLowerCase()) {
            case "yandex":
                return new YandexDriverFactory();
            case "chrome":
            default:
                return new ChromeDriverFactory();
        }
    }
}