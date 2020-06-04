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

    @FindBy(id = "dojo-link-nav")
    private WebElement dojosBtn;

    @FindBy(id = "ranking-link-nav")
    private WebElement rankingBtn;

    @FindBy(id = "profile-link-nav")
    private WebElement profileBtn;


    HomePage(WebDriver driver) {
        super(driver);
    }

    void load() {
        driver.get(baseUrl);
        wait.until(ExpectedConditions.visibilityOf(header));
    }

    HomePage login(String email, String password) {
        LoginModal loginModal = openUpLoginModal();
        return loginModal.login(email, password);
    }

    private LoginModal openUpLoginModal() {
        clickOn(loginBtn);
        return new LoginModal(driver);
    }

    boolean isLogoutButtonDisplayed() {
        return logoutBtn.isDisplayed();
    }

    void navigateToDojosPage() {
        clickOn(dojosBtn);
    }

    void navigateToRankingPage() {
        clickOn(rankingBtn);
    }

    void navigateToProfilePage() {
        clickOn(profileBtn);
    }
}
