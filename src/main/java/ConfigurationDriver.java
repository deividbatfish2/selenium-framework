import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationDriver {

    @Bean
    public WebDriver getWebdriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_linux64/chromedriver");
         WebDriver browser = new ChromeDriver();

        return browser;
    }
}
