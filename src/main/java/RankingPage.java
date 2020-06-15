import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RankingPage extends Page {

    @FindBy(className = "sc-Axmtr")
    List<WebElement> allUserPanels;

    public RankingPage(WebDriver driver) {
        super(driver);
    }

    public boolean areUsersVisible() {
        return allUserPanels.size() > 0;
    }

}
