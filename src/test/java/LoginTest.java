import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @BeforeEach
    public void setup() {
        homePage = new HomePage(driver);
        homePage.load();
    }

    @Test
    public void loginTest() {
        HomePage homePageAfterLogin = homePage.login(this.email, this.password);
        Assertions.assertTrue(homePageAfterLogin.isLogoutButtonDisplayed());
    }


}
