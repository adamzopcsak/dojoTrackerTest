package pages;

import exceptions.NoSuchDojoException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DojosPage extends Page {

    @FindBy(css = "div[id^=dojo-card-]")
    private List<WebElement> dojoCards;

    public DojosPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDojosListEmpty() {
        return dojoCards.isEmpty();
    }

    public void clickOnSpecificDojo(String dojoName) {
        WebElement currentDojo = null;
        try {
            currentDojo = getSpecificDojoByText(dojoName);
        } catch (NoSuchDojoException exception) {
            System.out.println(exception.getMessage());
        }
        clickOn(currentDojo);
    }

    private WebElement getSpecificDojoByText(String dojoName) throws NoSuchDojoException {
        for (WebElement dojoCard : dojoCards) {
            if (dojoCard.getText().equals(dojoName)) {
                return dojoCard;
            }
        }
        throw new NoSuchDojoException("Dojo with the name " + dojoName + " was not found.");
    }
}
