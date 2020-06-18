import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

    WebDriver driver;
    WebDriverWait wait;
    String baseUrl;

    public Page(WebDriver driver) {
        this.driver = driver;
        int timeOutInSeconds = 30;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeOutInSeconds), this);
        this.baseUrl = "https://track-that-dojo.herokuapp.com/";
        this.wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    public void clickOn(WebElement webElement) {
        webElement.click();
    }

    public void navigateToHomePage() {
        driver.get(this.baseUrl);
    }

    public void writeToField(String text, WebElement field) {
        field.sendKeys(text);
    }

    public void logout() {
        WebElement logoutBtn = driver.findElement(By.xpath("//div[@id='logout-btn']/div/button"));
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
        clickOn(logoutBtn);
    }
}
