import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        HomePage homePageAfterLogin = homePage.login(this.email, this.password);
        Assertions.assertTrue(homePageAfterLogin.isLogoutButtonDisplayed());
    }


}
