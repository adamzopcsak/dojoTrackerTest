import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected String username;
    protected String password;
    protected ChromeDriver driver;

    @BeforeAll
    public void setupTestEnvironment() {
        this.username = System.getenv("DOJOTRACKER_USERNAME");
        this.password = System.getenv("DOJOTRACKER_PASSWORD");
    }

    @BeforeEach
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

}
