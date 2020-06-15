import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class GoogleLoginPage extends Page {

    @FindBy(css = "input[type='email']")
    private WebElement emailInputField;

    @FindBy(css = "span[class='RveJvd snByac']")
    private WebElement nextBtn;

    //Clicking on the login button in headless mode renders a different login form (Google) with different locators,
    //so that is why these "next buttons" are needed
    @FindBy(id = "next")
    private WebElement nextBtn2;

    @FindBy(id = "submit")
    private WebElement nextBtn3;

    public GoogleLoginPage(WebDriver driver) {
        super(driver);
        Set<String> openedWindowsSet = driver.getWindowHandles();
        Object[] openedWindowsList = openedWindowsSet.toArray();
        driver.switchTo().window(openedWindowsList[getIndexOfLastElement(openedWindowsList)].toString());
    }

    public void fillEmailField(String emailAddress) {
        writeToField(emailAddress, emailInputField);
    }

    public void fillPasswordField(String password, WebElement passwordInputField) {
        writeToField(password, passwordInputField);
    }

    public HomePage login(String emailAddress, String password) {
        fillEmailField(emailAddress);
        try {
            clickOn(nextBtn);
        } catch (NoSuchElementException exception) {
            clickOn(nextBtn2);
        }

        By passwordFieldLocator = By.cssSelector("input[type='password']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        WebElement passwordInputField = driver.findElement(passwordFieldLocator);
        fillPasswordField(password, passwordInputField);
        try {
            clickOn(nextBtn);
        } catch (NoSuchElementException exception) {
            clickOn(nextBtn3);
        }

        driver.switchTo().window("");
        By logoutBtnLocator = By.id("logout-btn");
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtnLocator));
        return new HomePage(driver);
    }

    private int getIndexOfLastElement(Object[] array) {
        return array.length - 1;
    }
}
