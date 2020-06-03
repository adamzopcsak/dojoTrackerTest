import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomePageTest extends BaseTest {

    @BeforeEach
    public void setup() {
        homePage = new HomePage(driver);
        homePage.load();
    }

    @Test
    public void loginTest() {
        homePage.login();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
