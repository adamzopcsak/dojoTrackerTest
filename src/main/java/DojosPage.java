import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DojosPage extends Page {

    @FindBy(css = "div[id^=dojo-card-]")
    private List<WebElement> dojoCards;

    public DojosPage(WebDriver driver) {
        super(driver);
    }

    boolean isDojosListEmpty() {
        return dojoCards.isEmpty();
    }
}
