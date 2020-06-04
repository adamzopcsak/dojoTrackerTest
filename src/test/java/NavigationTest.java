import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NavigationTest extends BaseTest {

    @BeforeEach
    public void login() {
        homePage.login(this.email, this.password);
    }

    @Test
    public void navigateToDojosPage() {
        DojosPage dojosPage = homePage.navigateToDojosPage();
        Assertions.assertFalse(dojosPage.isDojosListEmpty());
    }

}
