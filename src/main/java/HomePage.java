import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends Page {

    @FindBy(tagName = "h1")
    private WebElement header;

    @FindBy(id = "login-btn")
    private WebElement loginBtn;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void load() {
        driver.get(baseUrl);
        wait.until(ExpectedConditions.visibilityOf(header));
    }

    public LoginModal openUpLoginModal() {
        clickOn(loginBtn);
        return new LoginModal(driver);
    }
}
