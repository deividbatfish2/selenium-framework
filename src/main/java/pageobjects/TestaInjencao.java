package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestaInjencao {
    private String baseUrl;



    @FindBy(name = "q")
    private WebElement txbSearch;

    public void searchFor(String search) {
        this.txbSearch.sendKeys(search);
        this.txbSearch.submit();
    }


}
