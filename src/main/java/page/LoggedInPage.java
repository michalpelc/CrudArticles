package page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedInPage extends FluentPage {

    @FindBy(xpath = "//input[@placeholder='Username']")
    private FluentWebElement userName;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private FluentWebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private FluentWebElement submitButton;

    public LoggedInPage login(String user, String password) {
        await().until(userName).displayed();
        userName.clear().fill().withText(user);
        userName.clear().fill().withText(user);
        submitButton.click();
        return this;
    }

}
