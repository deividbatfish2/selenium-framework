package eventlisteners;

import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

@Log
public class FindByListener extends AbstractWebDriverEventListener {
    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        log.info("Elemtn find: " + element.toString());
    }

}
