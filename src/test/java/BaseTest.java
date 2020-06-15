import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected final boolean HEADLESS_MODE = true;
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
        ChromeOptions options = new ChromeOptions();
        if (HEADLESS_MODE) {
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--headless");
            options.addArguments("--disable-popup-blocking");
        }
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        this.driver = new ChromeDriver(options);
        homePage = new HomePage(driver);
        homePage.load();
    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

}
