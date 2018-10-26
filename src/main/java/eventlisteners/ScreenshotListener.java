package eventlisteners;

import lombok.extern.java.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

@Log
public class ScreenshotListener extends AbstractWebDriverEventListener {

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        super.afterNavigateTo(url, driver);

        byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        try {
            ByteArrayInputStream outputFile = new ByteArrayInputStream(bytes);
            BufferedImage final_buffered_image = ImageIO.read(outputFile);
            File image = new File("./src/main/resources/" + url.replaceAll(":|/", "_") + ".png");
            ImageIO.write(final_buffered_image, "png", image);
            log.info("saved Image: "+ image);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
