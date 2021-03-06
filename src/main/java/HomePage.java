import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

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
        GoogleLoginPage loginModal = openUpLoginModal();
        return loginModal.login(email, password);
    }

    private GoogleLoginPage openUpLoginModal() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        clickOn(loginBtn);
        Object[] openedWindowsList = {};
        while (openedWindowsList.length < 2) {
            Set<String> openedWindowsSet = driver.getWindowHandles();
            openedWindowsList = openedWindowsSet.toArray();
        }
        return new GoogleLoginPage(driver);
    }

    boolean isLogoutButtonDisplayed() {
        return logoutBtn.isDisplayed();
    }

    boolean isSignInButtonDisplayed() {
        return loginBtn.isDisplayed();
    }

    DojosPage navigateToDojosPage() {
        clickOn(dojosBtn);
        return new DojosPage(driver);
    }

    RankingPage navigateToRankingPage() {
        clickOn(rankingBtn);
        return new RankingPage(driver);
    }

    ProfilePage navigateToProfilePage() {
        clickOn(profileBtn);
        return new ProfilePage(driver);
    }
}
