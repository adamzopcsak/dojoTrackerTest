import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Set;

public class LoginModal extends Page {

    @FindBy(css = "input[type='email']")
    private WebElement emailInputField;

    @FindBy(css = "span[class='RveJvd snByac']")
    private WebElement nextBtn;


    public LoginModal(WebDriver driver) {
        super(driver);
    }

    public void fillEmailField(String emailAddress) {
        writeToField(emailAddress, emailInputField);
    }

    public void fillPasswordField(String password, WebElement passwordInputField) {
        writeToField(password, passwordInputField);
    }

    public HomePage login(String emailAddress, String password) {
        Set<String> openedWindowsSet = driver.getWindowHandles();
        Object[] openedWindowsList = openedWindowsSet.toArray();
        driver.switchTo().window(openedWindowsList[getIndexOfLastElement(openedWindowsList)].toString());
        fillEmailField(emailAddress);
        clickOn(nextBtn);

        By passwordFieldLocator = By.cssSelector("input[type='password']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        WebElement passwordInputField = driver.findElement(passwordFieldLocator);
        fillPasswordField(password, passwordInputField);
        clickOn(nextBtn);

        driver.switchTo().window("");
        By logoutBtnLocator = By.id("logout-btn");
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtnLocator));
        return new HomePage(driver);
    }

    private int getIndexOfLastElement(Object[] array) {
        return array.length - 1;
    }
}
