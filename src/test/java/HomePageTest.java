import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomePageTest extends BaseTest {

    @BeforeEach
    public void setup() {
        homePage = new HomePage(driver);
        homePage.load();
    }


}
