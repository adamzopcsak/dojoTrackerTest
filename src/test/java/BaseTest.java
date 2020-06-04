import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected String email;
    protected String password;
    protected ChromeDriver driver;
    protected HomePage homePage;

    @BeforeAll
    public void setupTestEnvironment() {
        this.email = System.getenv("DOJOTRACKER_EMAIL");
        this.password = System.getenv("DOJOTRACKER_PASSWORD");
    }

    @BeforeEach
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        homePage.load();
    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

}
