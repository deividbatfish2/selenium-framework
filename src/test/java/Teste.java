import configuration.ConfigurationDriver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pageobjects.TestaInjencao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigurationDriver.class})
public class Teste {

    @Autowired
    private EventFiringWebDriver browser;

    @Test
    public void iniciaSelenium() {

        browser.get("http://www.google.com.br");

        TestaInjencao googlePage = PageFactory.initElements(browser, TestaInjencao.class);

        googlePage.searchFor("teste");

        browser.close();
    }
}
