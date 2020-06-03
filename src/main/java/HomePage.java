import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends Page {

    @FindBy(tagName = "h1")
    private WebElement header;

    @FindBy(id = "login-btn")
    private WebElement loginBtn;

    @FindBy(id = "logout-btn")
    private WebElement logoutBtn;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void load() {
        driver.get(baseUrl);
        wait.until(ExpectedConditions.visibilityOf(header));
    }

    public HomePage login(String email, String password) {
        LoginModal loginModal = openUpLoginModal();
        return loginModal.login(email, password);
    }

    private LoginModal openUpLoginModal() {
        clickOn(loginBtn);
        return new LoginModal(driver);
    }

    public boolean isLogoutButtonDisplayed() {
        return logoutBtn.isDisplayed();
    }
}
