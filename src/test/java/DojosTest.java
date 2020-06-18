import org.junit.jupiter.api.BeforeEach;

public class DojosTest extends BaseTest {

    @BeforeEach
    public void loginAndNavigateToDojosPage() {
        homePage.login(this.email, this.password);
        homePage.navigateToDojosPage();
    }



}
