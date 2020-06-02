import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void load() {
        driver.get(baseUrl);
    }
}
