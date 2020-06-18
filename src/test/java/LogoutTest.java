import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogoutTest extends BaseTest {

    @BeforeEach
    public void login() {
        homePage.login(this.email, this.password);
    }

    @Test
    public void logoutTest() {
        homePage.logout();
        Assertions.assertTrue(homePage.isSignInButtonDisplayed());
    }

}
