package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends Page {

    @FindBy(xpath = "//div[@class='sc-fzoXWK hnKkAN']/h3")
    WebElement username;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getUsername() {
        return username.getText();
    }
}
