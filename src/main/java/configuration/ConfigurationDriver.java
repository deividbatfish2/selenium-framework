package configuration;

import eventlisteners.FindByListener;
import eventlisteners.ScreenshotListener;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationDriver {

    @Bean
    public DesiredCapabilities desiredCapabilities(
            @Value("${webdriver.capabilities.browserName:firefox}") String browserName
    ) {
        return new DesiredCapabilities(browserName, "", Platform.ANY);
    }

    @Bean
    public WebDriver webdriver(DesiredCapabilities desiredCapabilities) {

        switch (desiredCapabilities.getBrowserName()) {
            case BrowserType.FIREFOX:
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver-v0.23.0-linux64/geckodriver");
                return new FirefoxDriver();
            case BrowserType.CHROME:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_linux64/chromedriver");
                return new ChromeDriver();
            default:
                throw new IllegalStateException("browser desconhecido" + desiredCapabilities.getBrowserName());
        }

    }

    @Bean
    public EventFiringWebDriver eventFiringWebDriver(WebDriver browser) {
        EventFiringWebDriver wrapBrowser = new EventFiringWebDriver(browser);

        wrapBrowser.register(new ScreenshotListener());
        wrapBrowser.register(new FindByListener());

        return wrapBrowser;
    }
}
