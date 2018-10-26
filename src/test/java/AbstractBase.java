import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigurationDriver.class})
public class AbstractBase {

    @Autowired
    public WebDriver browser;

    @Test
    public void iniciaSelenium() {

        browser.get("http://www.google.com.br");

        TestaInjencao googlePage = PageFactory.initElements(browser, TestaInjencao.class);

        googlePage.searchFor("teste");
    }
}
