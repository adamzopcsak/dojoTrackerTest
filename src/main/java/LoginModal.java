import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginModal extends Page {

    @FindBy(css = "input[type='email']")
    private WebElement emailInputField;

    public LoginModal(WebDriver driver) {
        super(driver);
    }

    public void fillEmailField(String emailAddress) {
        writeToField(emailAddress, emailInputField);
    }

}
